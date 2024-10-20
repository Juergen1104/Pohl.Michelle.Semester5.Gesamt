package P4.src;

class Punkt {
    public int x, y;

    public Punkt(int x, int y) {  // Konstuktor Punkt
        this.x = x;
        this.y = y;
    }
}

class Rechteck {
    public String name;
    public Punkt loEcke;        // linke, obere Ecke
    public int breite, hoehe;

    public Rechteck(String name, Punkt loEcke, int breite, int hoehe) {
        this.name = name;
        this.loEcke = loEcke;
        this.breite = breite;
        this.hoehe = hoehe;
    }
}

public class Rechtecke {

    /* *** Aufgabenteil (a) *** */
    public static void fuellen(Rechteck[] rechtecke) {

        for (int i = 0; i < rechtecke.length; i++) {
            String name = "R" + (i + 1);
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);
            int breite = (int) (Math.random() * 50) + 1;
            int hoehe = (int) (Math.random() * 50) + 1;
            rechtecke[i] = new Rechteck(name, new Punkt(x, y), breite, hoehe);

        }
    }

    /* *** Aufgabenteil (b) *** */
    public static void ausgeben(Rechteck[] rechtecke) {

        for (int i = 0; i < rechtecke.length; i++) {
            Rechteck r = rechtecke[i];
            int flaeche = groesse(r);  // Fläche

            System.out.println((i+1) + " " + "Rechteck");
            System.out.println("   Ecke:     (" + r.loEcke.x + "/" + r.loEcke.y + ")");
            System.out.println("   Groesse:  " + + r.breite + " x " + r.hoehe + " = " + flaeche);
            System.out.println("----------------");
        }
    }

    /* *** Aufgabenteil (c) *** */

    public static int groesse(Rechteck r) {
        return r.breite * r.hoehe;
    }

    public static int findeIndexVonMin(Rechteck[] rechtecke, int vonIndx) {

        int minIndex = vonIndx;
        for (int i = vonIndx + 1; i < rechtecke.length; i++) {
            if (groesse(rechtecke[i]) < groesse(rechtecke[minIndex])) {
                minIndex = i;
            }
        }
        return minIndex;

    }

    public static void sortieren(Rechteck[] rechtecke) {

        for (int i = 0; i < rechtecke.length - 1; i++) {
            int minIndex = findeIndexVonMin(rechtecke, i);
            if (minIndex != i) {
                // tauschfen
                Rechteck temp = rechtecke[i];
                rechtecke[i] = rechtecke[minIndex];
                rechtecke[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        Rechteck[] rechtecke = new Rechteck[N];

        fuellen(rechtecke);
        ausgeben(rechtecke);
        sortieren(rechtecke);
        ausgeben(rechtecke);
    }
}
