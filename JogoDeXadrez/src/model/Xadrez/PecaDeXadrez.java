package model.Xadrez;

import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {
  private Cor cor;

  public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro);
    this.cor = cor;
  }

  public Cor getCor() {
    return cor;
  }

  public PosicaoXadrez getPosicaoXadrez() {
    return PosicaoXadrez.fromPosicao(posicao);
  }

  protected boolean isExisteUmaPecaOponente(Posicao posicao) {
    PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
    return p != null && p.getCor() != cor;
  }
}
