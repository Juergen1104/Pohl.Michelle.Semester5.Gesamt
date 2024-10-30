package P7.src;// Michelle Pohl
/**
 * Testklasse zum Testen der Klasse Termin
 */
public class Terminplaner {
    public static void main(String[] args) {

        /* *** Aufgabenteil (f) *** */

        Termin pp1Vorlesung = new Termin("2024-09-05 12:00", 90 * 60 * 1000, "PP1 Vorlesung im HWS 24");

        Termin zahnarztTermin = new Termin("2024-12-03 15:00", 60 * 60 * 1000, "Zahnarztbesuch");

        // Erzeugung serie
        Termin[] pp1Serie = Termin.serieGenerieren(pp1Vorlesung, 14, 7);

        // 5. Termin 1 Tag zurück
        pp1Serie[4].verschieben(-1, "Tag");

        // Terminserie
        System.out.println("PP1 Vorlesungstermine (Serie):");
        for (Termin termin : pp1Serie) {
            System.out.println(termin);
        }

        System.out.println("\nZahnarzttermin vor der Verschiebung:");
        System.out.println(zahnarztTermin);

        // Verschieben
        zahnarztTermin.verschieben(-6, "Woche");
        zahnarztTermin.verschieben(-3, "Stunde");
        zahnarztTermin.verschieben(-30, "Minute");

        System.out.println("\nZahnarzttermin nach der Verschiebung:");
        System.out.println(zahnarztTermin);
    }


}

