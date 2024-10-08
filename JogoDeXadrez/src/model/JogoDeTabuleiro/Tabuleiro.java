package model.JogoDeTabuleiro;

public class Tabuleiro {
  private int linhas;
  private int colunas;
  private Peca[][] pecas;

  public Tabuleiro(int linhas, int colunas) {
    if (linhas < 1 || colunas < 1) {
      throw new TabuleiroException(
          "Erro ao criar o tabuleiro: deve haver pelo menos 1 linha e 1 coluna");
    }
    this.linhas = linhas;
    this.colunas = colunas;
    pecas = new Peca[linhas][colunas];
  }

  public int getLinhas() {
    return linhas;
  }

  public int getColunas() {
    return colunas;
  }

  public Peca peca(int linha, int coluna) {
    if (!isExistePosicao(linha, coluna)) {
      throw new TabuleiroException("Não existe essa posição no tabuleiro");
    }
    return pecas[linha][coluna];
  }

  public Peca peca(Posicao posicao) {
    if (!isExistePosicao(posicao)) {
      throw new TabuleiroException("Não existe essa posição no tabuleiro");
    }
    return pecas[posicao.getLinha()][posicao.getColuna()];
  }

  public void posicionarPeca(Peca peca, Posicao posicao) {
    if (isExistePeca(posicao)) {
      throw new TabuleiroException("Existe uma peça em posição " + posicao);
    }
    pecas[posicao.getLinha()][posicao.getColuna()] = peca;
    peca.posicao = posicao;
  }

  public Peca removerPeca(Posicao posicao) {
    if (!isExistePosicao(posicao)) {
      throw new TabuleiroException("Não existe essa posição no tabuleiro");
    }
    if (peca(posicao) == null) {
      return null;
    }
    Peca aux = peca(posicao);
    aux.posicao = null;
    pecas[posicao.getLinha()][posicao.getColuna()] = null;
    return aux;
  }

  private boolean isExistePosicao(int linha, int coluna) {
    return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
  }

  public boolean isExistePosicao(Posicao posicao) {
    return isExistePosicao(posicao.getLinha(), posicao.getColuna());
  }

  public boolean isExistePeca(Posicao posicao) {
    if (!isExistePosicao(posicao)) {
      throw new TabuleiroException("Não existe essa posição no tabuleiro");
    }
    return peca(posicao) != null;
  }
}
