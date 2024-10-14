package main;

import demo.Comentario;
import demo.Post;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
  public static void main(String[] args) throws Exception {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Comentario c1 = new Comentario("Have a nice trip!");
    Comentario c2 = new Comentario("Wow that's awessome");

    Date moment = sdf.parse("19/08/2024 16:34:20");
    String title = "Traveling to New Zealand";
    String content = "I'm going to visit this wonderful country!";
    Integer likes = 12;

    Post p1 = new Post(moment, title, content, likes);

    p1.addComentario(c1);
    p1.addComentario(c2);

    System.out.println(p1);


  }
}
