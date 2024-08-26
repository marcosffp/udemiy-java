package model.Xadrez;

import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {
  private Cor cor;
  private int contadorMovimento;

  public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro);
    this.cor = cor;
  }

  public Cor getCor() {
    return cor;
  }

  public int getContadorMovimento() {
    return contadorMovimento;
  }

  public void incrementarContadorMovimento() {
    contadorMovimento++;
  }

  public void decrementarContadorMovimento() {
    contadorMovimento--;
  }

  public PosicaoXadrez getPosicaoXadrez() {
    return PosicaoXadrez.fromPosicao(posicao);
  }

  protected boolean isExisteUmaPecaOponente(Posicao posicao) {
    PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
    return p != null && p.getCor() != cor;
  }
}
