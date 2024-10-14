package br.lpm.main;

import java.io.File;
import java.util.Scanner;

public class PastasFile {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o caminho: ");
    String strPath = sc.nextLine();

    File path = new File(strPath);

    File[] folders = path.listFiles(File::isDirectory);
    System.out.println("Folders: ");
    for (File file : folders) {
      System.out.println(file);
    }
    File[] files = path.listFiles(File::isFile);
    System.out.println("Files: ");
    for (File file : files) {
      System.out.println(file);
    }

    boolean sucesso = new File(strPath + "\\subdir").mkdir();
    System.out.println("Diretorio creiado com sucesso "+sucesso);

    sc.close();
  }
}
