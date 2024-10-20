package P2.src;//Michelle Pohl

public class Aufgabe_2_4 {

    public static void main(String[] args) {

        // Benutzer zur Eingabe der Zahl auffordern
        System.out.print("Bitte geben Sie eine Zahl ein, um die Wurzel zu berechnen: ");
        double a = IOTools.readDouble();

        boolean exit = false;
        double xn = (1 + a) / 2;

        double xn1;
        double epsilon = 10e-8;  // Abbruchkriterium für die Genauigkeit
        int cout = 0;

        // Iteration starten
        do {
            // Berechne xn+1 mit der Newton-Formel
            xn1 = (xn / 2) * (3 - (xn * xn) / a);

            cout++;

            // genau genug?
            if (Math.abs(xn1 - xn) <= epsilon) {
                exit = true;
            }
            xn = xn1;

        } while (!exit);

        // Ergebnis und Anzahl der Durchlaufe ausgeben
        System.out.printf("Wurzel aus %.1f approx. %.15f (%d Iterationen)\n", a, xn1, cout);
    }
}


