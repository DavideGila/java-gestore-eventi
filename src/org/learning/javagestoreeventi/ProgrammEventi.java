package org.learning.javagestoreeventi;

import java.util.List;

public class ProgrammEventi {
    // ATTRIBUTI
    private String titolo;
    private List<Evento> eventi;

    // COSTRUTTORI
    public ProgrammEventi(String titolo, List<Evento> eventi) {
        this.titolo = titolo;
        this.eventi = eventi;
    }

    // GETTER E SETTER
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    // METODI
}
