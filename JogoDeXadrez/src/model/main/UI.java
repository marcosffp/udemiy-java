package model.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Xadrez.Cor;
import model.Xadrez.PartidaDeXadrez;
import model.Xadrez.PecaDeXadrez;
import model.Xadrez.PosicaoXadrez;

public class UI {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  public static void limparTela() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
    try {
      String s = sc.nextLine();
      char coluna = s.charAt(0);
      int linha = Integer.parseInt(s.substring(1));
      return new PosicaoXadrez(coluna, linha);
    } catch (RuntimeException e) {
      throw new InputMismatchException(
          "Erro ao ler a posição do xadrez. Os valores válidos são de a1 a h8");
    }
  }

  public static void printXadrez(PartidaDeXadrez partidaDeXadrez, List<PecaDeXadrez> capturadas) {
    printTabuleiro(partidaDeXadrez.getPecas());
    System.out.println();
    printPecasCapturadas(capturadas);
    System.out.println();
    System.out.println("Turno: " + partidaDeXadrez.getTurno());
    if (!(partidaDeXadrez.getCheck())) {
      System.out.println("Aguardando o jogador(a): " + partidaDeXadrez.getJogadorAtual());

      if (partidaDeXadrez.getCheck()) {
        System.out.println("CHECK!");
      }
    } else {
      System.out.println("CHECKMATE!");
      System.out.println("Winner: "+partidaDeXadrez.getJogadorAtual());
    }
  }

  public static void printTabuleiro(PecaDeXadrez[][] pecaDeXadrezs) {
    for (int i = 0; i < pecaDeXadrezs.length; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < pecaDeXadrezs.length; j++) {
        printPeca(pecaDeXadrezs[i][j], false);
      }
      System.out.println();
    }
    System.out.println("  a b c d e f g h");
  }


  public static void printTabuleiro(
      PecaDeXadrez[][] pecaDeXadrezs, boolean[][] isMovimentosPossiveis) {
    for (int i = 0; i < pecaDeXadrezs.length; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < pecaDeXadrezs.length; j++) {
        printPeca(pecaDeXadrezs[i][j], isMovimentosPossiveis[i][j]);
      }
      System.out.println();
    }
    System.out.println("  a b c d e f g h");
  }

  private static void printPeca(PecaDeXadrez pecaDeXadrez, boolean background) {
    if (background) {
      System.out.print(ANSI_BLUE_BACKGROUND);
    }
    if (pecaDeXadrez == null) {
      System.out.print("-" + ANSI_RESET);
    } else {
      if (pecaDeXadrez.getCor() == Cor.BRANCO) {
        System.out.print(ANSI_WHITE + pecaDeXadrez + ANSI_RESET);
      } else {
        System.out.print(ANSI_YELLOW + pecaDeXadrez + ANSI_RESET);
      }
    }
    System.out.print(" ");
  }

  private static void printPecasCapturadas(List<PecaDeXadrez> capturadas) {
    List<PecaDeXadrez> branca =
        capturadas.stream().filter(x -> x.getCor() == Cor.BRANCO).collect(Collectors.toList());
    List<PecaDeXadrez> preta =
        capturadas.stream().filter(x -> x.getCor() == Cor.PRETO).collect(Collectors.toList());

    System.out.println("Peças capturadas: ");
    System.out.print("Brancas: ");
    System.out.print(ANSI_WHITE);
    System.out.println(Arrays.toString(branca.toArray()));
    System.out.print(ANSI_RESET);
    System.out.print("Pretas: ");
    System.out.print(ANSI_YELLOW);
    System.out.println(Arrays.toString(preta.toArray()));
    System.out.print(ANSI_RESET);
  }
}
