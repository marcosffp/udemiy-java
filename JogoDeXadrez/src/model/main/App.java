package model.main;

import model.Xadrez.PartidaDeXadrez;

public class App {
    public static void main(String[] args) throws Exception {
        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
        UI.printTabuleiro(partidaDeXadrez.getPecas());
        System.out.println();
    }
}
