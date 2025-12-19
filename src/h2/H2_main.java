package h2;


public class H2_main {
    public static void main(String[] args) {
        // Zum Testen (nicht explizit gefordert, aber sinnvoll)
        Bus busA = new Bus();
        Bus busB = new Bus();

        Passenger p1 = new Passenger("Anna", 2, true);
        Passenger p2 = new Passenger("Ben", 5, true);
        Passenger p3 = new Passenger("Clara", 3, false); // Kein Ticket

        busA.enterBus(p1);
        busA.enterBus(p2);
        busA.enterBus(p3);

        System.out.println("Passagiere in Bus A: " + busA.passengers.size());
        
        // Simuliere Transfer
        String[] transferNames = {"Anna", "Clara"};
        busA.transferPassengers(busB, transferNames);
        
        System.out.println("Nach Transfer - Bus A: " + busA.passengers.size()); // Sollte 1 sein (Ben)
        System.out.println("Nach Transfer - Bus B: " + busB.passengers.size()); // Sollte 2 sein (Anna, Clara)
    }
}
