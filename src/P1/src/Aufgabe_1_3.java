package P1.src;

//public class Aufgabe_1_3 {
//
//    public static void main(String[] args) {
////        System.out.println("Bitte geben Sie folgende Daten ein:");
////
////
////    }
//
//        // Eingabe des Grundkapitals
//        double kapital = IOTools.readDouble("Geben Sie Ihr Grundkapital K0 ein: ");
//
//        // Eingabe des Zinssatzes
//        double zinssatz = IOTools.readDouble("Geben Sie den Zinssatz p ein (in Prozent): ");
//
//        // Eingabe der Anzahl der Jahre
//        int jahre = IOTools.readInteger("Geben Sie die Anzahl der Jahre j ein: ");
//
//        // Berechnung des Kapitalwerts nach j Jahren
//        double kapitalNachJahren = kapital * Math.pow(1 + (zinssatz / 100), jahre);
//
//        // Ausgabe des Ergebnisses
//        System.out.printf("Nach %d Jahren beträgt Ihr Kapital: %.2f Euro%n", jahre, kapitalNachJahren);
//
//    }
//}
public class Aufgabe_1_3 {

    public static void main(String[] args) {
        // Eingabe  Grundkapitals
        double kapital = IOTools.readDouble("Geben Sie Ihr Grundkapital K0 ein: ");

        // Eingabe Zinssatzes
        double zinssatz = IOTools.readDouble("Geben Sie den Zinssatz p ein (in Prozent): ");

        // Eingabe Jahre
        int jahre = IOTools.readInteger("Geben Sie die Anzahl der Jahre j ein: ");

        // Berechnung Wert
        double kapitalNachJahren = kapital * Math.pow(1 + (zinssatz / 100), jahre);

        // Ausgabe des Ergebnisses
        System.out.printf("Nach %d Jahren beträgt Ihr Kapital: %.2f Euro%n", jahre, kapitalNachJahren);
        System.out.println("Nach " + jahre + " Jahren beträgt Ihr Kapital: " + kapitalNachJahren);

    }
}
