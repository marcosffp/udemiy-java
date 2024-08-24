package model.Pecas;

import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez {

  public Torre(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro, cor);
  }

  @Override
  public String toString() {
    return "T";
  }
}
