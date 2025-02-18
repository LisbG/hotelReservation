package com.lisboa.hotelreservation.model.entities;

import com.lisboa.hotelreservation.model.exception.DateException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private final Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");


    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    // Methods

    public long duration(){
        long dateDiff = (checkOut.getTime() - checkIn.getTime());
        return TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DateException{

        Date today = new Date();

        if (checkIn.before(today) || checkOut.before(today)){
            throw new DateException("CheckIn / CheckOut before now");
        }

        if (checkOut.before(checkIn)){
            throw new DateException("CheckOut before CheckIn");
        }
        setCheckIn(checkIn);
        setCheckOut(checkOut);
    }

    @Override
    public String toString(){
        return "Room number: " + getRoomNumber() +
                "\nCheck in: " + sdf.format(getCheckIn()) +
                "\nCheck out:" + sdf.format(getCheckOut()) +
                "\nDuration: " + duration() + " Nights";
    }
}