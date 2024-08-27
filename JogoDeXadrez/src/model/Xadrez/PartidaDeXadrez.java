package model.Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Pecas.Bispo;
import model.Pecas.Cavalo;
import model.Pecas.Peao;
import model.Pecas.Queen;
import model.Pecas.Rei;
import model.Pecas.Torre;

public class PartidaDeXadrez {
  private Tabuleiro tabuleiro;
  private int turno;
  private Cor jogadorAtual;
  private List<Peca> pecasNoTabuleiro = new ArrayList<>();
  private List<Peca> pecasCapturadas = new ArrayList<>();
  private boolean check;
  private boolean checkMate;
  private PecaDeXadrez vulneravelAEnPassant;
  private PecaDeXadrez promocao;

  public PartidaDeXadrez() {
    tabuleiro = new Tabuleiro(8, 8);
    turno = 1;
    jogadorAtual = Cor.BRANCO;
    configuracaoInicial();
  }

  public int getTurno() {
    return turno;
  }

  public boolean isCheckMate() {
    return checkMate;
  }

  public Cor getJogadorAtual() {
    return jogadorAtual;
  }

  public boolean getCheck() {
    return check;
  }

  public PecaDeXadrez getVulneravelAEnPassant() {
    return vulneravelAEnPassant;
  }

  public PecaDeXadrez getPromocao() {
    return promocao;
  }

  public PecaDeXadrez[][] getPecas() {
    PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
    for (int i = 0; i < tabuleiro.getLinhas(); i++) {
      for (int j = 0; j < tabuleiro.getColunas(); j++) {
        mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
      }
    }
    return mat;
  }

  public boolean[][] isMovimentosPosssiveis(PosicaoXadrez posicaoOrigem) {
    Posicao posicao = posicaoOrigem.toPosicao();
    validarPosicaoOrigem(posicao);
    return tabuleiro.peca(posicao).isMovimentosPosssiveis();
  }

  public PecaDeXadrez executarMovimentoXadrez(
      PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
    Posicao origem = posicaoOrigem.toPosicao();
    Posicao destino = posicaoDestino.toPosicao();
    validarPosicaoOrigem(origem);
    validarPosicaoDestino(origem, destino);
    Peca pecaCapturada = movimentoPeca(origem, destino);

    if (isTestCheck(jogadorAtual)) {
      desfazerMovimento(origem, destino, pecaCapturada);
      throw new XadrezException("Você não pode se colocar em check");
    }
    PecaDeXadrez pecaMoveu = (PecaDeXadrez) tabuleiro.peca(destino);

    // Movimento especial Promoção
    promocao = null;
    if (pecaMoveu instanceof Peao) {
      if ((pecaMoveu.getCor() == Cor.BRANCO && destino.getLinha() == 0)
          || (pecaMoveu.getCor() == Cor.PRETO && destino.getLinha() == 7)) {
        promocao = (PecaDeXadrez) tabuleiro.peca(destino);
        promocao = substituirPecaPromocao("Q");
      }
    }

    check = (isTestCheck(oponente(jogadorAtual))) ? true : false;
    if (isTestCheckMate(oponente(jogadorAtual))) {
      checkMate = true;
    } else {
      trocaTurno();
    }

    // Movimento especial en passant
    if (pecaMoveu instanceof Peao
        && (destino.getLinha() == origem.getLinha() - 2
            || destino.getLinha() == origem.getLinha() + 2)) {
      vulneravelAEnPassant = pecaMoveu;
    } else {
      vulneravelAEnPassant = null;
    }

    return (PecaDeXadrez) pecaCapturada;
  }

  public PecaDeXadrez substituirPecaPromocao(String tipo) {
    if (promocao == null) {
      throw new IllegalStateException("Não há peça para ser promovida");
    }
    if (!tipo.equals("B")
        && !tipo.equals("C")
        && !tipo.equals("P")
        && !tipo.equals("Q")
        && !tipo.equals("R")
        && !tipo.equals("T")) {
      return promocao;
    }
    Posicao pos = promocao.getPosicaoXadrez().toPosicao();
    Peca p = tabuleiro.removerPeca(pos);
    pecasNoTabuleiro.remove(p);

    PecaDeXadrez novaPeca = novaPeca(tipo, promocao.getCor());
    tabuleiro.posicionarPeca(novaPeca, pos);
    pecasNoTabuleiro.add(novaPeca);
    return novaPeca;
  }

  private PecaDeXadrez novaPeca(String tipo, Cor cor) {
    if (tipo.equals("B")) return new Bispo(tabuleiro, cor);
    if (tipo.equals("C")) return new Cavalo(tabuleiro, cor);
    if (tipo.equals("Q")) return new Queen(tabuleiro, cor);

    return new Torre(tabuleiro, cor);
  }

  private Peca movimentoPeca(Posicao origem, Posicao destino) {
    PecaDeXadrez p = (PecaDeXadrez) tabuleiro.removerPeca(origem);
    p.incrementarContadorMovimento();
    Peca pecaCapturada = tabuleiro.removerPeca(destino);
    tabuleiro.posicionarPeca(p, destino);

    if (pecaCapturada != null) {
      pecasNoTabuleiro.remove(pecaCapturada);
      pecasCapturadas.add(pecaCapturada);
    }

    // Movimento especial Roque-Torre pequeno
    if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
      Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
      Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
      PecaDeXadrez torre = (PecaDeXadrez) tabuleiro.removerPeca(origemT);
      tabuleiro.posicionarPeca(torre, destinoT);
      torre.incrementarContadorMovimento();
    }

    // Movimento especial Roque-Torre grande
    if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {
      Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
      Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
      PecaDeXadrez torre = (PecaDeXadrez) tabuleiro.removerPeca(origemT);
      tabuleiro.posicionarPeca(torre, destinoT);
      torre.incrementarContadorMovimento();
    }

    // Movimento especial en passant
    if (p instanceof Peao) {
      if (origem.getColuna() != destino.getColuna() && pecaCapturada == null) {
        Posicao posicaoPeao;
        if (p.getCor() == Cor.BRANCO) {
          posicaoPeao = new Posicao(destino.getLinha() + 1, destino.getColuna());
        } else {
          posicaoPeao = new Posicao(destino.getLinha() - 1, destino.getColuna());
        }
        pecaCapturada = tabuleiro.removerPeca(posicaoPeao);
        pecasCapturadas.add(pecaCapturada);
        pecasNoTabuleiro.remove(pecaCapturada);
      }
    }
    return pecaCapturada;
  }

  private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
    PecaDeXadrez p = (PecaDeXadrez) tabuleiro.removerPeca(destino);
    p.decrementarContadorMovimento();
    tabuleiro.posicionarPeca(p, origem);

    if (pecaCapturada != null) {
      tabuleiro.posicionarPeca(pecaCapturada, destino);
      pecasCapturadas.remove(pecaCapturada);
      pecasNoTabuleiro.add(pecaCapturada);
    }

    // Movimento especial Roque-Torre pequeno
    if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
      Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
      Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
      PecaDeXadrez torre = (PecaDeXadrez) tabuleiro.removerPeca(destinoT);
      tabuleiro.posicionarPeca(torre, origemT);
      torre.decrementarContadorMovimento();
    }

    // Movimento especial Roque-Torre grande
    if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {
      Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
      Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
      PecaDeXadrez torre = (PecaDeXadrez) tabuleiro.removerPeca(destinoT);
      tabuleiro.posicionarPeca(torre, origemT);
      torre.decrementarContadorMovimento();
    }

    // Movimento especial en passant
    if (p instanceof Peao) {
      if (origem.getColuna() != destino.getColuna() && pecaCapturada == vulneravelAEnPassant) {
        PecaDeXadrez peao = (PecaDeXadrez) tabuleiro.removerPeca(destino);

        Posicao posicaoPeao;
        if (p.getCor() == Cor.BRANCO) {
          posicaoPeao = new Posicao(3, destino.getColuna());
        } else {
          posicaoPeao = new Posicao(4, destino.getColuna());
        }
        tabuleiro.posicionarPeca(peao, posicaoPeao);
      }
    }
  }

  private void validarPosicaoOrigem(Posicao posicao) {
    if (!tabuleiro.isExistePeca(posicao)) {
      throw new XadrezException("Não existe peça na posição de origem");
    }
    if (jogadorAtual != ((PecaDeXadrez) tabuleiro.peca(posicao)).getCor()) {
      throw new XadrezException("A peça escolhida não é sua");
    }
    if (!(tabuleiro.peca(posicao).haAlgumMovimentoPossiveil())) {
      throw new XadrezException("Não existe movimentos possíveis para essa peça");
    }
  }

  private void validarPosicaoDestino(Posicao origem, Posicao destino) {
    if (!(tabuleiro.peca(origem).isMovimentoPosssivel(destino))) {
      throw new XadrezException("A peça escolhida não pode se mover para a posição de destino");
    }
  }

  private void trocaTurno() {
    turno++;
    jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
  }

  private Cor oponente(Cor cor) {
    return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
  }

  private PecaDeXadrez rei(Cor cor) {
    List<Peca> list =
        pecasNoTabuleiro.stream()
            .filter(x -> ((PecaDeXadrez) x).getCor() == cor)
            .collect(Collectors.toList());
    for (Peca peca : list) {
      if (peca instanceof Rei) {
        return (PecaDeXadrez) peca;
      }
    }
    throw new IllegalStateException("Não existe o rei com essa " + cor + " no tabuleiro");
  }

  private boolean isTestCheck(Cor cor) {
    Posicao posicaoRei = rei(cor).getPosicaoXadrez().toPosicao();
    List<Peca> pecasOponente =
        pecasNoTabuleiro.stream()
            .filter(x -> ((PecaDeXadrez) x).getCor() == oponente(cor))
            .collect(Collectors.toList());
    for (Peca peca : pecasOponente) {
      boolean[][] mat = peca.isMovimentosPosssiveis();
      if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
        return true;
      }
    }
    return false;
  }

  private boolean isTestCheckMate(Cor cor) {
    if (!isTestCheck(cor)) {
      return false;
    }
    List<Peca> list =
        pecasNoTabuleiro.stream()
            .filter(x -> ((PecaDeXadrez) x).getCor() == cor)
            .collect(Collectors.toList());
    for (Peca peca : list) {
      boolean[][] mat = peca.isMovimentosPosssiveis();
      for (int i = 0; i < tabuleiro.getLinhas(); i++) {
        for (int j = 0; j < tabuleiro.getColunas(); j++) {
          if (mat[i][j]) {
            Posicao origem = ((PecaDeXadrez) peca).getPosicaoXadrez().toPosicao();
            Posicao destino = new Posicao(i, j);
            Peca capturadaPeca = movimentoPeca(origem, destino);
            boolean testeCheck = isTestCheck(cor);
            desfazerMovimento(origem, destino, capturadaPeca);
            if (!testeCheck) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
    tabuleiro.posicionarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    pecasNoTabuleiro.add(peca);
  }

  private void configuracaoInicial() {
    colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('d', 1, new Queen(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO, this));

    colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('d', 8, new Queen(tabuleiro, Cor.PRETO));
    colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO, this));
  }
}
