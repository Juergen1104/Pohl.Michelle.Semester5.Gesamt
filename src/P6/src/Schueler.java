package P6.src;

import java.util.Scanner;

public class Schueler {
    private String name;
    private Fach[] faecher;

    public Schueler(String name, String[] fachNamen) {
        this.name = name;
        this.faecher = new Fach[fachNamen.length];
        for (int i = 0; i < fachNamen.length; i++) {
            faecher[i] = new Fach(fachNamen[i]);
        }
    }

    public String getName() {
        return name;
    }

    public Fach[] getFaecher() {
        return faecher;
    }

    public void erfasseErgebnisse() {
        Scanner scanner = new Scanner(System.in);
        for (Fach fach : faecher) {
            float note;
            do {
                System.out.print("Note für " + fach.getName() + ": ");
                note = scanner.nextFloat();
            } while (note < 1.0 || note > 6.0);
            fach.setNote(note);
        }
    }
}
