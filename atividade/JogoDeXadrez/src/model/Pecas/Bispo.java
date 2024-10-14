package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PecaDeXadrez;

public class Bispo extends PecaDeXadrez {

  public Bispo(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro, cor);
  }

  @Override
  public String toString() {
    return "B";
  }

  @Override
  public boolean[][] isMovimentosPosssiveis() {
    boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

    Posicao aux = new Posicao(0, 0);

    // Noroeste
    aux.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setValores(aux.getLinha() - 1, aux.getColuna() - 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Nordeste
    aux.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setValores(aux.getLinha() - 1, aux.getColuna() + 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Sudeste
    aux.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setValores(aux.getLinha() + 1, aux.getColuna() + 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Sudoeste
    aux.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setValores(aux.getLinha() + 1, aux.getColuna() - 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    return mat;
  }
}
