package model.Xadrez;

import model.JogoDeTabuleiro.Peca;
import model.JogoDeTabuleiro.Posicao;
import model.JogoDeTabuleiro.Tabuleiro;
import model.Pecas.Bispo;
import model.Pecas.Cavalo;
import model.Pecas.Peao;
import model.Pecas.Rainha;
//import model.Pecas.Rei;
import model.Pecas.Torre;

public class PartidaDeXadrez {
  private Tabuleiro tabuleiro;

  public PartidaDeXadrez() {
    tabuleiro = new Tabuleiro(8, 8);
    configuracaoInicial();
  }

  public PecaDeXadrez[][] getPecas() {
    PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
    for (int i = 0; i < tabuleiro.getLinhas(); i++) {
      for (int j = 0; j < tabuleiro.getColunas(); j++) {
        mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
      }
    }
    return mat;
  }

  public PecaDeXadrez pexecutarMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
    Posicao origem = posicaoOrigem.toPosicao();
    Posicao destino = posicaoDestino.toPosicao();
    validarPosicaoOrigem(origem);
    Peca pecaCapturada = movimentoPeca(origem, destino);
    return (PecaDeXadrez) pecaCapturada;

  }

  private Peca movimentoPeca(Posicao origem, Posicao destino) {
    Peca p = tabuleiro.removerPeca(origem);
    Peca pecaCapturada = tabuleiro.removerPeca(destino);
    tabuleiro.posicionarPeca(p, destino);
    return pecaCapturada;
  }

  private void validarPosicaoOrigem(Posicao posicao) {
    if (!tabuleiro.isExistePeca(posicao)) {
      throw new XadrezException("Não existe peça na posição de origem");
    }
  }

  private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
    tabuleiro.posicionarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
}

private void configuracaoInicial() {
    colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('b', 1, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('c', 1, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('d', 1, new Rainha(tabuleiro, Cor.BRANCO));
    //colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO, this));
    colocarNovaPeca('f', 1, new Bispo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('g', 1, new Cavalo(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('h', 1, new Torre(tabuleiro, Cor.BRANCO));
    colocarNovaPeca('a', 2, new Peao(tabuleiro, Cor.BRANCO));
    //colocarNovaPeca('b', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    //colocarNovaPeca('c', 2, new Peao(tabuleiro, Cor.BRANCO, this));
   // colocarNovaPeca('d', 2, new Peao(tabuleiro, Cor.BRANCO, this));
   // colocarNovaPeca('e', 2, new Peao(tabuleiro, Cor.BRANCO, this));
    //colocarNovaPeca('f', 2, new Peao(tabuleiro, Cor.BRANCO, this));
   // colocarNovaPeca('g', 2, new Peao(tabuleiro, Cor.BRANCO, this));
   // colocarNovaPeca('h', 2, new Peao(tabuleiro, Cor.BRANCO, this));

    colocarNovaPeca('a', 8, new Torre(tabuleiro, Cor.PRETO));
    colocarNovaPeca('b', 8, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('c', 8, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('d', 8, new Rainha(tabuleiro, Cor.PRETO));
   // colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO, this));
    colocarNovaPeca('f', 8, new Bispo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('g', 8, new Cavalo(tabuleiro, Cor.PRETO));
    colocarNovaPeca('h', 8, new Torre(tabuleiro, Cor.PRETO));
    //colocarNovaPeca('a', 7, new Peao(tabuleiro, Cor.PRETO, this));
   // colocarNovaPeca('b', 7, new Peao(tabuleiro, Cor.PRETO, this));
   // colocarNovaPeca('c', 7, new Peao(tabuleiro, Cor.PRETO, this));
   // colocarNovaPeca('d', 7, new Peao(tabuleiro, Cor.PRETO, this));
    //colocarNovaPeca('e', 7, new Peao(tabuleiro, Cor.PRETO, this));
   // colocarNovaPeca('f', 7, new Peao(tabuleiro, Cor.PRETO, this));
   // colocarNovaPeca('g', 7, new Peao(tabuleiro, Cor.PRETO, this));
    //colocarNovaPeca('h', 7, new Peao(tabuleiro, Cor.PRETO, this));
}

}
