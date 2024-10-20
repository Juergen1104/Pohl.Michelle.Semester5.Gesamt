package P3.src;// Michelle Pohl

public class Aufgabe_3_2 {

    public static void main(String[] args) {
        int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int z;

        /* *** Aufgabenteil (a) *** */
        // 3 P

        System.out.println("Aufgabenteil (a):");

        // (a) Benutzer nach einer Zahl fragen und Paare finden

        do {
            System.out.print("Geben Sie eine Zahl aus dem Intervall [4; 100] ein: ");
            z = IOTools.readInteger();
        } while (z < 4 || z > 100);  // Wiederholen, bis Zahl im richtigen Bereich

        System.out.println("Paare von Primzahlen, deren Summe " + z + " ergibt:");
        for (int i = 0; i < prim.length; i++) {
            for (int j = i; j < prim.length; j++) {
                if (prim[i] + prim[j] == z) {
                    System.out.println(prim[i] + " + " + prim[j] + " = " + z);
                }
            }
        }

        /* *** Aufgabenteil (b) *** */
        // 4 P

        System.out.println("\nAufgabenteil (b):");

        for (int zahl = 4; zahl <= 100; zahl++) {
            boolean gefunden = false;
            for (int i = 0; i < prim.length && !gefunden; i++) {
                for (int j = i; j < prim.length && !gefunden; j++) {
                    if (prim[i] + prim[j] == zahl) {
                        System.out.println(prim[i] + " + " + prim[j] + " = " + zahl);
                        gefunden = true;
                    }
                }
            }
            if (!gefunden) {
                System.out.println("Nichts gefunden fuer " + zahl);
            }
        }
    }
}

