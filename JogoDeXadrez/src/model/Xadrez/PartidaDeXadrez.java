package model.Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Pecas.Rei;
import model.Pecas.Torre;

public class PartidaDeXadrez {
  private Tabuleiro tabuleiro;
  private int turno;
  private Cor jogadorAtual;
  private List<Peca> pecasNoTabuleiro = new ArrayList<>();
  private List<Peca> pecasCapturadas = new ArrayList<>();
  private boolean check;


  public PartidaDeXadrez() {
    tabuleiro = new Tabuleiro(8, 8);
    turno = 1;
    jogadorAtual = Cor.BRANCO;
    configuracaoInicial();
  }


  public int getTurno() {
    return turno;
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
  

    trocaTurno();
    return (PecaDeXadrez) pecaCapturada;
  }

  private Peca movimentoPeca(Posicao origem, Posicao destino) {
    Peca p = tabuleiro.removerPeca(origem);
    Peca pecaCapturada = tabuleiro.removerPeca(destino);
    tabuleiro.posicionarPeca(p, destino);

    if (pecaCapturada != null) {
      pecasNoTabuleiro.remove(pecaCapturada);
      pecasCapturadas.add(pecaCapturada);
    }
    return pecaCapturada;
  }
  
  private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
    Peca p = tabuleiro.removerPeca(destino);
    tabuleiro.posicionarPeca(p, origem);

    if (pecaCapturada !=null) {
      tabuleiro.posicionarPeca(pecaCapturada, destino);
      pecasCapturadas.remove(pecaCapturada);
      pecasNoTabuleiro.add(pecaCapturada);
    }
  }

  private void validarPosicaoOrigem(Posicao posicao) {
    if (!tabuleiro.isExistePeca(posicao)) {
      throw new XadrezException("Não existe peça na posição de origem");
    }
    if (jogadorAtual != ((PecaDeXadrez)tabuleiro.peca(posicao)).getCor()) {
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
    jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.PRETO;
  }

  private Cor oponente(Cor cor) {
    return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
  }

  private PecaDeXadrez rei(Cor cor) {
    List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez) x).getCor() == cor)
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

  private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
    tabuleiro.posicionarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    pecasNoTabuleiro.add(peca);
  }

  private void configuracaoInicial() {
    colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));

    colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
    colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
  }
}
