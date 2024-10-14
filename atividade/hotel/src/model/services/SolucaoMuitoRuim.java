package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.demo.ReservationMuitoRuim;

public class SolucaoMuitoRuim {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.print("Room number: ");
    Integer roomNumber = sc.nextInt();
    System.out.print("Check-in date (dd/mm/aaaa): ");
    Date checkIn = sdf.parse(sc.next());
    System.out.print("Check-out date (dd/mm/aaaa): ");
    Date checkOut = sdf.parse(sc.next());

    if (!checkOut.after(checkIn)) {
      System.out.println("Error inreservation: Check-out date must be after check-in date");
    } else {
      ReservationMuitoRuim reservation = new ReservationMuitoRuim(roomNumber, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);
      System.out.println();
      System.out.println("Enter data to update the reservation: ");
      System.out.print("Check-in date (dd/mm/aaaa): ");
      checkIn = sdf.parse(sc.next());
      System.out.print("Check-out date (dd/mm/aaaa): ");
      checkOut = sdf.parse(sc.next());

      Date now = new Date();
      if (checkIn.before(now) || checkOut.before(now)) {
        System.out.println(
            "Error in reservation: Reservation dates for update must be future dates");
      } else if (!checkOut.after(checkIn)) {
        System.out.println("Error inreservation: Check-out date must be after check-in date");
      } else {
        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " + reservation);
      }
    }

    sc.close();
  }
}
