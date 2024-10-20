package P4.src;// Michelle Pohl
import java.util.Random;

public class Wuerfel {
    public static int max = 6;  // maximale Augenzahl auf dem Wuerfel
    private static int zaehler = 1;  // Klassenvariable zur eindeutigen Nummerierung
    public int nr;

    /* *** Aufgabenteil (a) *** */
    public int wert;

    /* *** Aufgabenteil (a) *** */

    public Wuerfel() {
        this.wert = 1;  // Initialer Wert des Würfels ist 1
        this.nr = zaehler++;  // Zuweisung einer fortlaufenden Nummer
    }

    public void werfen() {
        Random random = new Random();
        this.wert = random.nextInt(max) + 1;
    }

    public void print() {
        System.out.println("Wuerfel Nr. " + this.nr + " -> " + this.wert);
    }
}
