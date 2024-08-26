package model.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Xadrez.PartidaDeXadrez;
import model.Xadrez.PecaDeXadrez;
import model.Xadrez.PosicaoXadrez;
import model.Xadrez.XadrezException; 

public class App {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
    List<PecaDeXadrez> capturadas = new ArrayList<>();

    while (!partidaDeXadrez.isCheckMate()) {
      try {
        UI.limparTela();
        UI.printXadrez(partidaDeXadrez, capturadas);
        System.out.println();
        System.out.print("Origem: ");
        PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

        boolean[][] isMovimentosPosssiveis = partidaDeXadrez.isMovimentosPosssiveis(origem);
        UI.limparTela();
        UI.printTabuleiro(partidaDeXadrez.getPecas(), isMovimentosPosssiveis);

        System.out.println();
        System.out.print("Destino: ");
        PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

        PecaDeXadrez pecaCapturada = partidaDeXadrez.executarMovimentoXadrez(origem, destino);
        if (pecaCapturada != null) {
          capturadas.add(pecaCapturada);
        }
      } catch (XadrezException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
      }
    }
    UI.limparTela();
    UI.printXadrez(partidaDeXadrez, capturadas);
    sc.close();
  }
}
