package org.learning.javagestoreeventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    // ATTRIBUTI
    private LocalTime time;
    private BigDecimal price;

    // COSTRUTTORI
    public Concerto(String title, LocalDate date, int locationCapacity, LocalTime time, BigDecimal price)
            throws IllegalArgumentException {
        super(title, date, locationCapacity);
        this.time = time;
        this.price = price;
    }

    // GETTER E SETTER
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // METODI
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return getDate().format(formatter);
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getTime().format(formatter);
    }

    public String getFormattedPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("##,##€");
        return decimalFormat.format(price);
    }

    @Override
    public String toString() {
        return getFormattedDate() + " " + getFormattedTime() + " - " + getTitle() + " - " + getFormattedPrice();
    }

}
