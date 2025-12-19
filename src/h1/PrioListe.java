package h1;

import java.util.ArrayList;

public class PrioListe {
    private ArrayList<Patient> myList;

    public PrioListe() {
        myList = new ArrayList<>();
    }

    public void addPatient(Patient p) {
        if (myList.isEmpty()) {
            myList.add(p);
            return;
        }

        int pos = 0;
        while (pos < myList.size() && myList.get(pos).prio < p.prio) {
            pos++;
        }
        myList.add(pos, p);
    }

    public Patient getNextPatient() {
        if (myList.isEmpty()) {
            return null;
        }
        return myList.remove(0);
    }

    public int getPosition(Patient p) {
        return myList.indexOf(p);
    }
}
