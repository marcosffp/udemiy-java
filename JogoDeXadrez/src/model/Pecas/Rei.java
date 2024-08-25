package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez {

  public Rei(Tabuleiro tabuleiro, Cor cor) {
    super(tabuleiro, cor);
  }

  @Override
  public String toString() {
    return "R";
  }

  private boolean isPodeMover(Posicao posicao) {
    PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
    return p == null || p.getCor() != getCor();
  }

  @Override
  public boolean[][] isMovimentosPosssiveis() {
    boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

    Posicao p = new Posicao(0, 0);

    //Acima
    p.setValores(posicao.getLinha() - 1, posicao.getColuna());
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Abaixo
    p.setValores(posicao.getLinha() + 1, posicao.getColuna());
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Esquerda
    p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Direita
    p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Noroeste
    p.setValores(posicao.getLinha()-1, posicao.getColuna() - 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Nordeste
    p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Sudoeste
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    // Sudeste
    p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
    if (getTabuleiro().isExistePosicao(p) && isPodeMover(p)) {
      mat[p.getLinha()][p.getColuna()] = true;
    }

    return mat;
  }
}
