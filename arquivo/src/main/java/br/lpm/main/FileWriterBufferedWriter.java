package br.lpm.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterBufferedWriter {
  public static void main(String[] args) {
    String[] lines = new String[] { "Good morning", "Good Afternoon", "Good night" };

    String path = "C:\\temp\\out.txt";
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
      for (String string : lines) {
        bw.write(string);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
