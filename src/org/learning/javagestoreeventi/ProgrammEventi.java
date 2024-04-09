package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEventi {
    // ATTRIBUTI
    private String titolo;
    private List<Evento> eventi;

    // COSTRUTTORI
    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
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
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiInData(LocalDate data) {
        return eventi.stream()
                .filter(e -> e.getDate().equals(data))
                .collect(Collectors.toList());
    }

    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    public String elencoEventiOrdinatiPerData() {
        // ordina gli eventi per data
        eventi.sort(Comparator.comparing(Evento::getDate));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Titolo del programma: ").append(titolo).append("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Evento evento : eventi) {
            String dataFormattata = evento.getDate().format(formatter);
            stringBuilder.append(dataFormattata).append(" - ").append(evento.getTitle()).append("\n");
        }

        return stringBuilder.toString();
    }
}
