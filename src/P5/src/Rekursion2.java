package P5.src;

// Michelle Pohl
public class Rekursion2 {

    /* *** Aufgabenteil (a) *** */
    public static int quadratRek(int a) {

        // a=0
        if (a == 0) {
            return 0; // 0^2 = 0
        }
        // Rekursiver Fall
        return quadratRek(a - 1) + 2 * a - 1;

    }

    /* *** Aufgabenteil (b) *** */

    public static int treppen(int n, String s) {
        if (n == 0) {
            System.out.println(s);
            return 1; // Eine Möglichkeit gefunden
        }

        if (n == 1) {
            System.out.println(s + "-1");
            return 1;
        }

        // Eine  oder zwei?
        int moeglichkeiten = 0;
        moeglichkeiten += treppen(n - 1, s + "-1");
        moeglichkeiten += treppen(n - 2, s + "-2");
        return moeglichkeiten;
    }

    /* *** Aufgabenteil (c) *** */
    public static int naechstesElement(int a_i) {
        if (a_i % 2 == 0) {
            return a_i / 2; // Wenn a gerade ist
        } else {
            return 3 * a_i + 1; // Wenn a ungerade ist
        }
    }

    public static void collatz(int a, int count) {

        System.out.print(a + " ");

        // Basisfall: Wenn a == 1, endet die Folge
        if (a == 1) {
            System.out.println();
            System.out.println("Länge der Folge: " + count);
            return;
        }

        collatz(naechstesElement(a), count + 1);
    }

    public static void main(String[] args) {

        /* *** Test  Aufgabenteil (a) *** */
        System.out.println("(a)");
        int z;
        do {
            z = IOTools.readInteger("z = ");
        } while (z < 0);
        System.out.println("z^2 = " + quadratRek(z));

        /* *** Test  Aufgabenteil (b) *** */
        System.out.println("\n(b)");
        int n = IOTools.readInteger("n = ");
        int count = treppen(n, "");
        System.out.println("Anzahl der Möglichkeiten: " + count);

        /* *** Test  Aufgabenteil (c) *** */
        System.out.println("\n(c)");
        int a0 = IOTools.readInteger("a_0 = ");
        collatz(a0, 1);

    }
}
