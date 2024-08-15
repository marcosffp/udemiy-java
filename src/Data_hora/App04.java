package Data_hora;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class App04 {
  public static void main(String[] args) {
    LocalDate d04 = LocalDate.parse("2024-08-20");
    LocalDateTime d05 = LocalDateTime.parse("2024-08-20T01:30:26");
    Instant d06 = Instant.parse("2024-08-20T01:30:26Z");

    LocalDate semanaAnteriorLocalDate = d04.minusDays(7);
    LocalDate proximaSemanaLocalDate = d04.plusDays(7);

    System.out.println("data: " + d04);
    System.out.println("-----------------");
    System.out.println("semana anterior usando o  LocalDate = " + semanaAnteriorLocalDate);
    System.out.println("proxíma semana usando o LocalDate = " + proximaSemanaLocalDate);
    System.out.println("-----------------");
    System.out.println();

    LocalDateTime semanaAnteriorLocalDateTime = d05.minusDays(7);
    LocalDateTime proximaSemanaLocalDateTime = d05.plusDays(7);

    System.out.println("data: " + d05);
    System.out.println("-----------------");
    System.out.println("semana anterior usando o  LocalDateTime = " + semanaAnteriorLocalDateTime);
    System.out.println("proxíma semana usando o LocalDateTime = " + proximaSemanaLocalDateTime);
    System.out.println("-----------------");
    System.out.println();
    
    Instant semanaAnteriorInstant = d06.minus(7, ChronoUnit.DAYS);
    Instant proximaSemanaInstant = d06.plus(7, ChronoUnit.DAYS);

    System.out.println("data: " + d06);
    System.out.println("-----------------");
    System.out.println("semana anterior usando o  Instant = " + semanaAnteriorInstant);
    System.out.println("proxíma semana usando o Instant = " + proximaSemanaInstant);
    System.out.println("-----------------");
    System.out.println();


    Duration t1 = Duration.between(semanaAnteriorLocalDate.atStartOfDay(), d04.atStartOfDay());
    Duration t2 = Duration.between(semanaAnteriorLocalDateTime, d05);
    Duration t3 = Duration.between(semanaAnteriorInstant, d06);
    Duration t4 = Duration.between(d06,semanaAnteriorInstant);
    
    

    System.out.println("t1 dias = " + t1.toDays());
    System.out.println("t2 dias = " + t2.toDays());
    System.out.println("t3 dias = " + t3.toDays());
    System.out.println("t4 dias = " + t4.toDays());
    
  }
}
