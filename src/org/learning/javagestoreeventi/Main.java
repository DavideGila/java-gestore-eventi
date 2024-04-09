package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Creazione di un nuovo evento.");
            System.out.print("Inserisci il nome dell'evento: ");
            String title = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (formato YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.print("Inserisci la capacità di posti dell'evento: ");
            int capacity = Integer.parseInt(scanner.nextLine());

            Evento event = new Evento(title, date, capacity);

            System.out.print("Vuoi effettuare delle prenotazioni? (s/n): ");
            String responseReservation = scanner.nextLine();

            if ("s".equalsIgnoreCase(responseReservation)) {
                System.out.print("Quanti posti vuoi prenotare? ");
                int placesToReserve = Integer.parseInt(scanner.nextLine());
                try {
                    event.book(placesToReserve);
                    System.out.println("Prenotazione effettuata.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore nella prenotazione: " + e.getMessage());
                }
            }

            System.out.println("Posti prenotati: " + event.getNumberOfPlacesBooked() + ". Posti disponibili: " +
                    (event.getLocationCapacity() - event.getNumberOfPlacesBooked()));

            System.out.print("Vuoi disdire dei posti? (s/n): ");
            String responseDischarge = scanner.nextLine();

            if ("s".equalsIgnoreCase(responseDischarge)) {
                System.out.print("Quanti posti vuoi disdire? ");
                int placesToDisorder = Integer.parseInt(scanner.nextLine());
                try {
                    event.cancel(placesToDisorder);
                    System.out.println("Disdetta effettuata.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Errore nella disdetta: " + e.getMessage());
                }
            }

            System.out.println("Posti prenotati: " + event.getNumberOfPlacesBooked() + ". Posti disponibili: " +
                    (event.getLocationCapacity() - event.getNumberOfPlacesBooked()));

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
        
        scanner.close();
    }
}
