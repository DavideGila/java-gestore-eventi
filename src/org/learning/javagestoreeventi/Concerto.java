package org.learning.javagestoreeventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
}
