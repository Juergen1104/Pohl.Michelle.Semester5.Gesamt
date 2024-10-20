package P6.src;

public class ZeugnisSchreiber {

    public static void schreiben(Schueler schueler) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Z E U G N I S");
        System.out.println("Name: " + schueler.getName());

        Fach[] faecher = schueler.getFaecher();
        float summe = 0;
        for (Fach fach : faecher) {
            System.out.println(fach);
            summe += fach.getNote();
        }

        float durchschnitt = summe / faecher.length;
        if (durchschnitt <= 1.3) {
            System.out.println("\nDer Schüler erhält eine Auszeichnung für im Durchschnitt sehr gute Noten.");
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        String[] faecher = {"Mathematik", "Deutsch", "Latein", "Sport"};
        Schueler schueler = new Schueler("Alex Schmidt", faecher);
        schueler.erfasseErgebnisse();
        schreiben(schueler);
    }
}
