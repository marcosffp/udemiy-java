package model.Pecas;

import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Xadrez.Cor;
import model.Xadrez.PartidaDeXadrez;
import model.Xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez {

  private PartidaDeXadrez partidaDeXadrez;

  public Rei(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaDeXadrez) {
    super(tabuleiro, cor);
    this.partidaDeXadrez = partidaDeXadrez;
  }

  private boolean isJogadaEspecialTorre(Posicao posicao) {
    PecaDeXadrez aux = (PecaDeXadrez) getTabuleiro().peca(posicao);
    return aux != null && aux instanceof Torre && aux.getCor() == getCor() && aux.getContadorMovimento() == 0;
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

    //Jogada Special Roque
    if (getContadorMovimento()==0&&!partidaDeXadrez.getCheck()) {
      //Torre do lado direito (pequeno)
      Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
      if (isJogadaEspecialTorre(posT1)) {
        Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
        Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
        if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null) {
          mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
        }
      }
      // Torre do lado esquerdo (grande)
      Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() -4);
      if (isJogadaEspecialTorre(posT2)) {
        Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
        Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
        Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
        if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null&&getTabuleiro().peca(p3)==null) {
          mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
        }
      }
    }

    return mat;
  }
}
