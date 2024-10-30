package P7.src;// Michelle Pohl
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Termin {
    private LocalDateTime zeit; /* Datums-Object für den Zeitpunkt
                                   an dem der Termin beginnt */
    private Duration dauer;     /* Dauer des Termins in Millisekunden */
    private String todo;        /* (Kurz-)Beschreibung des Termins */

    /* Default-Konstruktor für ein "leeres" Terminobjekt.
       Von aussen soll nur ein Termin mit konkreten Daten-Parametern
       generiert werden.
     */
    private Termin() {
    }

    /* *** Aufgabenteil (a) *** */

    public Termin(String startZeit, int dauerMillisekunden, String beschreibung) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.zeit = LocalDateTime.parse(startZeit, formatter);

        this.dauer = Duration.ofMillis(dauerMillisekunden);

        this.todo = beschreibung;
    }

    private Termin(LocalDateTime zeit, Duration dauer, String todo) {
        this.zeit = zeit;
        this.dauer = dauer;
        this.todo = todo;
    }

    public static Termin[] serieGenerieren(Termin musterTermin, int n, int k) {
        Termin[] termine = new Termin[n]; // Array zum Speichern der generierten Termine

        for (int i = 0; i < n; i++) {
            Termin terminKopie = musterTermin.clone(); // Erstellen einer Kopie des Musters
            terminKopie.zeit = terminKopie.zeit.plus(i * k, ChronoUnit.DAYS); // Verschieben um i * k Tage
            termine[i] = terminKopie; // Kopie in das Array einfügen
        }
        return termine; // Rückgabe des Arrays mit der Serie von Terminen
    }

    public LocalDateTime getZeit() {
        return zeit;
    }


    /* *** Aufgabenteil (b) *** */

    public Duration getDauer() {
        return dauer;
    }

    public String getTodo() {
        return todo;
    }






    /* *** Aufgabenteil (c) *** */

    public Termin clone() {
        LocalDate dateCopy = LocalDate.of(zeit.getYear(), zeit.getMonth(), zeit.getDayOfMonth());
        LocalTime timeCopy = LocalTime.of(zeit.getHour(), zeit.getMinute(), zeit.getSecond());
        LocalDateTime zeitCopy = LocalDateTime.of(dateCopy, timeCopy);

        Duration dauerCopy = Duration.ofMillis(dauer.toMillis());

        return new Termin(zeitCopy, dauerCopy, new String(todo));
    }

    /* *** Aufgabenteil (d) *** */

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd.MM.yyyy HH:mm'h'", Locale.GERMANY);
        LocalDateTime endZeit = zeit.plus(dauer);

        result.append("Termin: ").append(todo).append("\n");
        result.append("Beginn: ").append(zeit.format(formatter)).append("\n");
        result.append("Ende: ").append(endZeit.format(formatter)).append("\n");

        return result.toString();
    }


    /* *** Aufgabenteil (e) *** */

    public void verschieben(int anzahl, String einheit) {
        ChronoUnit chronoUnit;
        switch (einheit.toLowerCase()) {
            case "woche":
                chronoUnit = ChronoUnit.WEEKS;
                break;
            case "tag":
                chronoUnit = ChronoUnit.DAYS;
                break;
            case "stunde":
                chronoUnit = ChronoUnit.HOURS;
                break;
            case "minute":
                chronoUnit = ChronoUnit.MINUTES;
                break;
            default:
                throw new IllegalArgumentException("Ungültige Zeiteinheit: " + einheit);
        }
        this.zeit = this.zeit.plus(anzahl, chronoUnit);
    }


}