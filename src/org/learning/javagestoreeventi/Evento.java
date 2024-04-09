package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getLocationCapacity() {
        return locationCapacity;
    }

    public int getNumberOfPlacesBooked() {
        return numberOfPlacesBooked;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // METODI
    public void book(int placesToReserve) throws IllegalArgumentException {
        // fatto la stessa eccezione della data nel costruttore poichè qui è necessario per gestire situazioni
        // in cui l'evento è stato creato per una data futura, ma al momento di eseguire la funzione, la data è
        // diventata passata
        if (this.date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato, non è possibile prenotare.");
        }
        if (this.numberOfPlacesBooked + placesToReserve > this.locationCapacity) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
        }
        this.numberOfPlacesBooked += placesToReserve;
    }

    public void cancel(int placesToDisorder) throws IllegalArgumentException {
        if (this.date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato, non è possibile disdire.");
        }
        if (placesToDisorder > this.numberOfPlacesBooked) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti prenotati da disdire.");
        }
        this.numberOfPlacesBooked -= placesToDisorder;
    }

    @Override
    public String toString() {
        // crea un formattatore di date basato su un pattern specificato come stringa
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.date.format(formatter) + " - " + this.title;
    }
}
