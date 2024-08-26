package model.Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Pecas.Peao;
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
    check = (isTestCheck(oponente(jogadorAtual))) ? true : false;
    if (isTestCheckMate(oponente(jogadorAtual))) {
      checkMate = true;
    } else {
      trocaTurno();
    }

    return (PecaDeXadrez) pecaCapturada;
  }

  private Peca movimentoPeca(Posicao origem, Posicao destino) {
    PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removerPeca(origem);
    p.incrementarContadorMovimento();
    Peca pecaCapturada = tabuleiro.removerPeca(destino);
    tabuleiro.posicionarPeca(p, destino);

    if (pecaCapturada != null) {
      pecasNoTabuleiro.remove(pecaCapturada);
      pecasCapturadas.add(pecaCapturada);
    }
    return pecaCapturada;
  }

  private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
    PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removerPeca(destino);
    p.decrementarContadorMovimento();
    tabuleiro.posicionarPeca(p, origem);

    if (pecaCapturada != null) {
      tabuleiro.posicionarPeca(pecaCapturada, destino);
      pecasCapturadas.remove(pecaCapturada);
      pecasNoTabuleiro.add(pecaCapturada);
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
    colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO));

    colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
    colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO));
    colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO));
  }
}
