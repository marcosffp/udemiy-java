package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PecaDeXadrez;

public class Queen extends PecaDeXadrez {

  public Queen(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro, cor);
  }

  @Override
  public String toString() {
    return "Q";
  }

  @Override
  public boolean[][] isMovimentosPosssiveis() {
    boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

    Posicao aux = new Posicao(0, 0);

    // Cima
    aux.setValores(posicao.getLinha() - 1, posicao.getColuna());
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setLinha(aux.getLinha() - 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Esquerda
    aux.setValores(posicao.getLinha(), posicao.getColuna() - 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setColuna(aux.getColuna() - 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Direita
    aux.setValores(posicao.getLinha(), posicao.getColuna() + 1);
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setColuna(aux.getColuna() + 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }

    // Abaixo
    aux.setValores(posicao.getLinha() + 1, posicao.getColuna());
    while (getTabuleiro().isExistePosicao(aux) && !getTabuleiro().isExistePeca(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
      aux.setLinha(aux.getLinha() + 1);
    }
    if (getTabuleiro().isExistePosicao(aux) && isExisteUmaPecaOponente(aux)) {
      mat[aux.getLinha()][aux.getColuna()] = true;
    }
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
