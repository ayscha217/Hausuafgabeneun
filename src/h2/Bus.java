package h2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class Bus {
    // Die Liste der Passagiere im Bus
    public ArrayList<Passenger> passengers;

    // Öffentlicher Konstruktor ohne Parameter
    public Bus() {
        this.passengers = new ArrayList<>(); // Initialisiert die Liste leer
    }

    // Methode zum Einsteigen
    public void enterBus(Passenger p) {
        this.passengers.add(p); // Fügt Passagier ans Ende der Liste hinzu
    }

    // Private Methode zum Aussteigen (Prüfung)
    private void exitBus() {
        // Wir nutzen einen Iterator, um sicher Elemente während einer Schleife zu löschen
        Iterator<Passenger> it = this.passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            // Wenn geplante Stationen == besuchte Stationen, muss er raus
            if (p.planned == p.visited) {
                it.remove(); // Entfernt den Passagier sicher aus der Liste
            }
        }
    }

    // Nächster Halt mit zusteigenden Passagieren
    public void nextStop(Passenger[] boarding) {
        // 1. Visited bei allen aktuellen Passagieren erhöhen
        for (Passenger p : this.passengers) {
            p.visited++;
        }

        // 2. Prüfen, wer aussteigen muss
        exitBus();

        // 3. Neue Passagiere einsteigen lassen
        for (Passenger p : boarding) {
            enterBus(p);
        }
    }

    // Überladene Methode: Nächster Halt OHNE zusteigende Passagiere
    public void nextStop() {
        // Ruft die obere Methode mit einem leeren Array auf
        nextStop(new Passenger[0]); 
    }

    // Schwarzfahrer finden und rauswerfen
    public ArrayList<Passenger> findPassengersWithoutTickets() {
        ArrayList<Passenger> removedPassengers = new ArrayList<>();
        
        Iterator<Passenger> it = this.passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (!p.ticket) { // Wenn kein Ticket (ticket == false)
                removedPassengers.add(p); // Zur Rückgabeliste hinzufügen
                it.remove();              // Aus dem Bus entfernen
            }
        }
        return removedPassengers;
    }

    // Passagiere in einen anderen Bus transferieren
    public void transferPassengers(Bus otherBus, String[] passengerNames) {
        // Hilfsliste für einfachere Namenssuche erstellen
        List<String> namesToTransfer = Arrays.asList(passengerNames);
        
        Iterator<Passenger> it = this.passengers.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            // Wenn der Name des Passagiers in der Transfer-Liste steht
            if (namesToTransfer.contains(p.name)) {
                otherBus.enterBus(p); // In den anderen Bus steigen
                it.remove();          // Aus dem aktuellen Bus entfernen
            }
        }
    }
}