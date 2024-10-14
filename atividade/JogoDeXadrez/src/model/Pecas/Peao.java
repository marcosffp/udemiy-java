package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PartidaDeXadrez;
import model.Xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez {
  private PartidaDeXadrez partidaDeXadrez;

  public Peao(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaDeXadrez) {
    super(tabuleiro, cor);
    this.partidaDeXadrez = partidaDeXadrez;
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
      // Movimento especial en passant (branca)
      if (posicao.getLinha() == 3) {
        Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
        if (getTabuleiro().isExistePosicao(esquerda)
            && isExisteUmaPecaOponente(esquerda)
            && getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelAEnPassant()) {
          mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
        }
        Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
        if (getTabuleiro().isExistePosicao(direita)
            && isExisteUmaPecaOponente(direita)
            && getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelAEnPassant()) {
          mat[direita.getLinha() - 1][direita.getColuna()] = true;
        }
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
      // Movimento especial en passant (preta)
      if (posicao.getLinha() == 4) {
        Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
        if (getTabuleiro().isExistePosicao(esquerda)
            && isExisteUmaPecaOponente(esquerda)
            && getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelAEnPassant()) {
          mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
        }
        Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
        if (getTabuleiro().isExistePosicao(direita)
            && isExisteUmaPecaOponente(direita)
            && getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelAEnPassant()) {
          mat[direita.getLinha() + 1][direita.getColuna()] = true;
        }
      }
    }

    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }
}
