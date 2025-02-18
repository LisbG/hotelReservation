package com.lisboa.hotelreservation.application;

import com.lisboa.hotelreservation.model.entities.Reservation;
import com.lisboa.hotelreservation.model.entities.SystemOptions;
import com.lisboa.hotelreservation.model.exception.DateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        List<Reservation> reservations = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Scanner sc = new Scanner(System.in);

        Date checkIn;
        Date checkOut;
        int room;
        int option;

        do {
            System.out.println(SystemOptions.mainOptions());
            System.out.print("Option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:

                    try {
                        System.out.print("Room: ");
                        room = sc.nextInt();

                        System.out.print("Check in date: ");
                        checkIn = sdf.parse(sc.next());

                        System.out.print("Check out date: ");
                        checkOut = sdf.parse(sc.next());

                        reservations.add(new Reservation(room, checkIn, checkOut));
                    } catch (ParseException e) {
                        System.out.println("invalid data format");
                    }
                    catch (DateException e){
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 2:
                    int roomNumber;
                    roomNumber = sc.nextInt();

                    for (Reservation reservation : reservations) {
                        if (reservation.getRoomNumber() == roomNumber) {
                            int reservationOption;
                            do {
                                System.out.println(SystemOptions.reservationOptions());
                                System.out.print("Option: ");
                                reservationOption = sc.nextInt();

                                switch (reservationOption) {
                                    case 1:
                                        Date newCheckInDate;
                                        Date newCheckOutDate;
                                        try {
                                            System.out.print("Check in date: ");
                                            newCheckInDate = sdf.parse(sc.next());

                                            System.out.print("Check out date: ");
                                            newCheckOutDate = sdf.parse(sc.next());

                                            reservation.updateDates(newCheckInDate, newCheckOutDate);

                                            System.out.println("Reservation date updated!");
                                        } catch (ParseException e) {
                                            System.out.println("Invalid data type!");

                                        } catch (DateException e) {
                                            System.out.println("Error during date update: " + e.getMessage());
                                        }
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Go for a valid option!");
                                        break;
                                }

                            } while (reservationOption != 0);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Go for a valid option!");
                    break;
            }
        } while (option != 0);

        for (Reservation reservation : reservations) {
            System.out.println(reservation.toString());
        }
    }

}
