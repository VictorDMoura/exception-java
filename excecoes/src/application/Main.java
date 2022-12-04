package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in Date(dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtf1);
        System.out.print("Check-ou Date(dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtf1);

        if(checkIn.isAfter(checkOut)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in Date(dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf1);
            System.out.print("Check-ou Date(dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf1);

            if(checkIn.isAfter(checkOut)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else if(checkIn.isBefore(reservation.getCheckIn()) || checkOut.isBefore(reservation.getCheckOut())){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();

    }
}