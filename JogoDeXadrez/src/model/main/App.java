package model.main;

import java.util.Scanner;
import model.Xadrez.PartidaDeXadrez;
import model.Xadrez.PecaDeXadrez;
import model.Xadrez.PosicaoXadrez;

public class App {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

    while (true) {
      UI.printTabuleiro(partidaDeXadrez.getPecas());
      System.out.println();
      System.out.print("Origem (ou 'sair' para encerrar): ");
      String input = sc.nextLine();
      if (input.equalsIgnoreCase("sair")) {
        break;
      }
      PosicaoXadrez origem =
          UI.lerPosicaoXadrez(new Scanner(input)); 

      System.out.println();
      System.out.print("Destino: ");
      PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

      PecaDeXadrez pecaCapturada = partidaDeXadrez.executarMovimentoXadrez(origem, destino);

      if (pecaCapturada != null) {
        System.out.println("Peça capturada: " + pecaCapturada);
      }
    }

    sc.close();
  }
}
