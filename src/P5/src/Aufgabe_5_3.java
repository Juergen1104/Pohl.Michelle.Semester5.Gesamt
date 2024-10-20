package P5.src;

public class Aufgabe_5_3 {
    public static void main(String[] args) {
        Liste liste = new Liste(); // neue Liste anlegen
        /* Liste fuellen */
        liste.insert(new Ausgabe(12, "August", 31.55, "Lebensmittel"));
        liste.insert(new Ausgabe(1, "August", 3.55, "Backwaren"));
        liste.insert(new Ausgabe(9, "September", 42.10, "Lebensmittel"));
        liste.insert(new Ausgabe(4, "August", 7.50, "Backwaren"));
        liste.insert(new Ausgabe(10, "August", 3.80, "Backwaren"));
        liste.insert(new Ausgabe(3, "September", 178.00, "Bekleidung"));
        liste.insert(new Ausgabe(28, "September", 39.00, "Fahrkarte"));
        liste.insert(new Ausgabe(11, "August", 8.80, "Backwaren"));
        liste.insert(new Ausgabe(5, "August", 35.56, "Lebensmittel"));
        liste.insert(new Ausgabe(19, "August", 29.50, "Lebensmittel"));
        liste.insert(new Ausgabe(18, "August", 10.20, "Backwaren"));
        liste.insert(new Ausgabe(2, "September", 37.50, "Lebensmittel"));
        liste.insert(new Ausgabe(6, "August", 0.95, "Backwaren"));
        liste.insert(new Ausgabe(1, "August", 3.50, "Zeitung"));
        liste.insert(new Ausgabe(8, "August", 12.35, "Schreibwaren"));
        liste.insert(new Ausgabe(16, "September", 52.10, "Lebensmittel"));
        liste.insert(new Ausgabe(1, "August", 14.95, "Bücher"));

        /* Liste ausgeben */
        liste.print();
        System.out.println();
        /* Teillisten für jeden Monat bilden */
        Liste august = liste.getAusgabenListeMonat("August");
        Liste september = liste.getAusgabenListeMonat("September");
        /* Summe der Ausgaben bestimmen und ausgeben */
        System.out.print("Ausgaben im August: ");
        System.out.println(august.getSummeAusgaben());
        System.out.print("Ausgaben im September: ");
        System.out.println(september.getSummeAusgaben());
        System.out.println();
        /* Teil-Listen sortieren */
        august.sort2();      // alternativ sort2 eintragen
        september.sort2();   // alternativ sort2 eintragen
        /* Teil-Listen ausgeben */
        // august.print();
        System.out.println();
        september.print();
        System.out.println();

    }


}
