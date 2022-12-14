package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static java.time.temporal.ChronoUnit.DAYS;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut){
        if(checkIn.isAfter(checkOut)) {
            throw  new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    public long duration(){
       return DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut){
        if(checkIn.isAfter(checkOut)) {
            throw  new DomainException("Check-out date must be after check-in date");
        }
        if(checkIn.isBefore(this.getCheckIn()) || checkOut.isBefore(this.getCheckOut())){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + dtf1.format(checkIn)
                + ", check-ou: "
                + dtf1.format(checkOut)
                + ",  "
                + duration()
                +" nights";
    }
}
