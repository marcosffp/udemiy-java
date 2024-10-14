package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.demo.ReservationBoa;
import model.exceptions.DomainException;

public class SolucaoBoa {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      System.out.print("Room number: ");
      Integer roomNumber = sc.nextInt();
      System.out.print("Check-in date (dd/mm/aaaa): ");
      Date checkIn = sdf.parse(sc.next());
      System.out.print("Check-out date (dd/mm/aaaa): ");
      Date checkOut = sdf.parse(sc.next());

      ReservationBoa reservation = new ReservationBoa(roomNumber, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);
      System.out.println();
      System.out.println("Enter data to update the reservation: ");
      System.out.print("Check-in date (dd/mm/aaaa): ");
      checkIn = sdf.parse(sc.next());
      System.out.print("Check-out date (dd/mm/aaaa): ");
      checkOut = sdf.parse(sc.next());


      reservation.updateDates(checkIn, checkOut);
      

      System.out.println("Reservation: " + reservation);
    } catch (ParseException e) {
      System.out.println("Invalid date format");
    } catch (DomainException e) {
      System.out.println("Error in reservation: " + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println("Unexpected error");
    }

    sc.close();
  }
}
