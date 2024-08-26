package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez {

  public Peao(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro, cor);
  }

  @Override
  public boolean[][] isMovimentosPosssiveis() {
    boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
    Posicao aux = new Posicao(0, 0);

    if (getCor() == Cor.BRANCO) {
      aux.setValores(posicao.getLinha() - 1, posicao.getColuna());
      if (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() - 2, posicao.getColuna());
      Posicao aux2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
      if (getTabuleiro().isExistePosicao(aux)
          && !getTabuleiro().isExistePeca(aux)
          && getContadorMovimento() == 0
          && getTabuleiro().isExistePosicao(aux2)
          && !getTabuleiro().isExistePeca(aux2)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
      if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
      if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
    } else {
      aux.setValores(posicao.getLinha() + 1, posicao.getColuna());
      if (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() + 2, posicao.getColuna());
      Posicao aux2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
      if (getTabuleiro().isExistePosicao(aux)
          && !getTabuleiro().isExistePeca(aux)
          && getContadorMovimento() == 0
          && getTabuleiro().isExistePosicao(aux2)
          && !getTabuleiro().isExistePeca(aux2)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
      if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
      aux.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
      if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
        mat[aux.getLinha()][aux.getColuna()] = true;
      }
    }

    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }
}
