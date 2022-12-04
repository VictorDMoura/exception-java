package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in Date(dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dtf1);
            System.out.print("Check-ou Date(dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dtf1);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in Date(dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), dtf1);
            System.out.print("Check-ou Date(dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), dtf1);


            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (DateTimeParseException e){
            System.out.println("Illegal date format!");
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();

    }
}