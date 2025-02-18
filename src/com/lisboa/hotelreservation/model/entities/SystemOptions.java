package com.lisboa.hotelreservation.model.entities;

public class SystemOptions {

    public static StringBuilder mainOptions() {
        StringBuilder string = new StringBuilder();

        string.append("1 - Add reservation\n");
        string.append("2 - Manage reservation\n");
        string.append("0 - Exit\n");

        return string;
    }

    public static StringBuilder reservationOptions() {
        StringBuilder string = new StringBuilder();

        string.append("1 - Change dates\n");
        string.append("0 - Exit\n");

        return string;
    }
}
