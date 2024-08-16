package Data_hora;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;



public class App06 {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
    System.out.println(sdf.format(d));

    Calendar cal = Calendar.getInstance(); 
    cal.setTime(d);
    int minutos = cal.get(Calendar.MINUTE);
    int meses = 1+ cal.get(Calendar.MONTH);

    System.out.println("Minutos: " + minutos);
    System.out.println("Meses: "+meses);
  }
}
