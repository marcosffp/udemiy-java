package model.JogoDeTabuleiro;

public  abstract class Peca {
  protected Posicao posicao;
  private Tabuleiro tabuleiro;

  public Peca(Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
    posicao = null;
  }

  protected Tabuleiro getTabuleiro() {
    return tabuleiro;
  }

  public abstract boolean[][] isMovimentosPosssiveis();

  public boolean isMovimentoPosssivel(Posicao posicao) {
    return isMovimentosPosssiveis()[posicao.getLinha()][posicao.getColuna()];
  }

  public boolean haAlgumMovimentoPossiveil() {
    boolean[][] mat = isMovimentosPosssiveis();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat.length; j++) {
        if (mat[i][j]) {
          return true;
        }
      }
    }
    return false;
  }
}
