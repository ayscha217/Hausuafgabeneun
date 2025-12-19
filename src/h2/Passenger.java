package h2;

public class Passenger {
    // Attribute
    public String name;
    public int planned;
    public int visited;
    public boolean ticket;

    // Konstruktor
    public Passenger(String name, int planned, boolean ticket) {
        this.name = name;       // Setzt den Namen
        this.planned = planned; // Setzt die geplante Anzahl Stationen
        this.ticket = ticket;   // Setzt den Ticket-Status
        this.visited = 0;       // Initialisiert visited immer mit 0
    }
}