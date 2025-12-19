package h1;

public class H1_main {
    public static void main(String[] args) {
        PrioListe liste = new PrioListe();

        Patient A = new Patient("A", 1);
        Patient B = new Patient("B", 10);
        Patient C = new Patient("C", 5);
        Patient D = new Patient("D", 7);

        liste.addPatient(A);
        liste.addPatient(B);
        liste.addPatient(C);

        System.out.println("Liste nach A, B, C eingefügt:");

        System.out.println("Position von A: " + liste.getPosition(A));
        System.out.println("Position von B: " + liste.getPosition(B));
        System.out.println("Position von C: " + liste.getPosition(C));

        liste.addPatient(D);

        System.out.println("Liste nach D eingefügt:");
        System.out.println("Position von D: " + liste.getPosition(D));

        System.out.println("Alle Patienten in Reihenfolge:");

        Patient p;
        while ((p = liste.getNextPatient()) != null) {
            System.out.println(p);
        }
    }
}
