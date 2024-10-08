package demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Post {
  private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  private Date moment;
  private String title;
  private String content;
  private Integer likes;

  private List<Comentario> comentarios = new ArrayList<>();

  public Post() {}

  public Post(Date moment, String title, String content, Integer likes) {
    this.setMoment(moment);
    this.setTitle(title);
    this.setContent(content);
    this.setLikes(likes);
  }

  public Date getMoment() {
    return moment;
  }

  public void setMoment(Date moment) {
    this.moment = moment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getLikes() {
    return likes;
  }

  public void setLikes(Integer likes) {
    this.likes = likes;
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }

  public void addComentario(Comentario comentario) {
    comentarios.add(comentario);
  }

  public void removeComentario(Comentario comentario) {
    comentarios.remove(comentario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(title + "\n");
    sb.append(likes);
    sb.append(" Likes - ");
    sb.append(sdf.format(moment) + "\n");
    sb.append(content + "\n");
    sb.append("Comments: \n");
    for (Comentario comentario : comentarios) {
      sb.append(comentario.getText()+"\n");
    }
    return sb.toString();


  }
}
