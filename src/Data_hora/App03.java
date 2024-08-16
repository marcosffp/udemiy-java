package Data_hora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class App03 {

  public static void main(String[] args) {

    LocalDate d04 = LocalDate.parse("2024-08-15");
    LocalDateTime d05 = LocalDateTime.parse("2024-08-15T01:30:26");
    Instant d06 = Instant.parse("2024-08-15T01:30:26Z");

    // data-hora global para local
    LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
    LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
    LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
    LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));


    

    System.out.println("r1 = " + r1);
    System.out.println("r1 = " + r2);
    System.out.println("r1 = " + r3);
    System.out.println("r1 = " + r4);
    System.out.println("--------------");

    // Data-hora local ➞ dia, mês, ano, horário
    System.out.println("d04= " + d04);
    System.out.println("d04 dia= " + d04.getDayOfMonth());
    System.out.println("d04 mes= " + d04.getMonthValue());
    System.out.println("d04 ano= " + d04.getYear());
    System.out.println("--------------");

    System.out.println("d05= "+d05);
    System.out.println("d05 hora= " + d05.getHour());
    System.out.println("d05 minuto= " + d05.getMinute());
    System.out.println("d05 segundo= "+d05.getSecond());
  }
    

   

}
