package org.learning.javagestoreeventi;

import java.time.LocalDate;

public class Evento {
    // ATTRIBUTI
    private String title;
    private LocalDate date;
    private int locationCapacity;
    private int numberOfPlacesBooked;

    // COSTRUTTORI
    public Evento(String title, LocalDate date, int locationCapacity) throws IllegalArgumentException {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere già passata.");
        }
        if (locationCapacity <= 0) {
            throw new IllegalArgumentException("La capacità della location deve essere più di zero.");
        }

        this.title = title;
        this.date = date;
        this.locationCapacity = locationCapacity;
        this. numberOfPlacesBooked = 0;
    }

    // GETTER E SETTER

    // METODI
}
