package P3.src;

// Michelle Pohl
public class Aufgabe_3_1 {

    // Methode fuellt das Feld mit Zufallszahlen aus derm Intervall [1,100]
    public static void fillRand(int[] feld) {
        for (int i = 0; i < feld.length; i++) {
            feld[i] = (int) (Math.random() * 100) + 1;
        }
    }

    public static void main(String[] args) {
        int[] feld = new int[10];
        fillRand(feld);

        /* *** Aufgabenteil (a) *** */
        // 1.5

        for (int i = 0; i < feld.length; i++) {
            System.out.print(feld[i]);
            // kein "-" nach der 10. Zahl
            if (i < 9) {
                System.out.print("-");
            }
        }
        System.out.println();

        /* *** Aufgabenteil (b) *** */
        int gerade = 0, ungerade = 0, differenz;
        // 3
        for (int j : feld) {
            if (j % 2 == 0) {
                gerade++;
            } else ungerade++;
        }

        for (int i = 0; i < feld.length; i++) {
            if (feld[i] % 2 == 0) {
                gerade++;
            } else ungerade++;
        }

        if (gerade == ungerade) {
            System.out.println("Das Feld enthaelt gleich viele gerade und ungerade Zahlen");
        } else if (gerade > ungerade) {
            differenz = gerade - ungerade;
            System.out.println("Das Feld enthaelt " + differenz + " gerade Zahlen mehr als ungerade Zahlen.");
        } else {
            differenz = ungerade - gerade;
            System.out.println("Das Feld enthaelt " + differenz + " gerade Zahlen weniger als ungerade Zahlen.");
        }

        /* *** Aufgabenteil (c) *** */
        // 2.5

        int maxDiff = 0;
        int indexMaxDiff = 0;

        for (int i = 0; i < feld.length - 1; i++) {
            int diff = Math.abs(feld[i] - feld[i + 1]);
            if (diff > maxDiff) {
                maxDiff = diff;
                indexMaxDiff = i;
            }
        }
        System.out.println("Die max. Differenz von " + maxDiff + " tritt auf zwischen feld[" + indexMaxDiff + "] und feld[" + (indexMaxDiff + 1) + "].");
    }
}




