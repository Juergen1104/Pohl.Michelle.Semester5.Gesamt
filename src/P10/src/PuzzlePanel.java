package P10.src;// Michelle Pohl
import javax.swing.*;
import java.awt.*;

public class PuzzlePanel extends JPanel {
    private int dim;
    private ZahlButton[][] teile;
    private Schiebepuzzle parent;

    public PuzzlePanel(Schiebepuzzle parent, int n) {
        this.parent = parent;
        this.dim = n;
        this.teile = new ZahlButton[n][n];
        /* Aufgabenteil (a) */

        int zahl = 1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (zahl < dim * dim) {
                    teile[i][j] = new ZahlButton(zahl);
                    zahl++;
                } else {
                    teile[i][j] = new ZahlButton(); // Leerteil
                }
                this.add(teile[i][j]);
            }
        }

        this.setLayout(new GridLayout(dim, dim));
        this.revalidate();
        this.mischen();

        // Test Nachbar und auf Konsole ausgeben
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                ZahlButton leerfeld = checkLeerteilNachbar(teile[i][j]);
                System.out.println("Button (" + i + ", " + j + "): " +
                        (leerfeld != null ? "Nachbar ist Leerfeld" : "Kein Leerfeld als Nachbar"));
            }
        }
    }

    private void mischen() {
        /* Aufgabenteil (b) */

        int n = this.dim;
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 50; i++) {
            // Zufällige Positionen für den ersten Button
            int row1 = random.nextInt(n);
            int col1 = random.nextInt(n);

            // Zufällige Positionen für den zweiten Button
            int row2 = random.nextInt(n);
            int col2 = random.nextInt(n);

            // Tausche die Buttons an den zufälligen Positionen
            teile[row1][col1].tauscheMit(teile[row2][col2]);
        }

        // Repaint, um die Änderungen sichtbar zu machen
        this.revalidate();
        this.repaint();
    }

    public ZahlButton checkLeerteilNachbar(ZahlButton zb) {
        /* Aufgabenteil (c) */

        // Position des gegebenen Puzzleteils (zb) im Spielfeld finden
        int zeile = -1, spalte = -1;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (teile[i][j] == zb) {
                    zeile = i;
                    spalte = j;
                    break;
                }
            }
            if (zeile != -1) break; // Sobald die Position gefunden wurde, Schleife abbrechen
        }

        int[][] nachbarn = {
                {zeile - 1, spalte}, // oben
                {zeile + 1, spalte}, // unten
                {zeile, spalte - 1}, // links
                {zeile, spalte + 1}  // rechts
        };

        // Nachbarn prüfen
        for (int[] nachbar : nachbarn) {
            int z = nachbar[0];
            int s = nachbar[1];
            if (z >= 0 && z < dim && s >= 0 && s < dim) {
                if (teile[z][s].istLeerfeld()) {
                    return teile[z][s];
                }
            }
        }
        return null;
    }

    public boolean fertig() {
        /* Aufgabenteil (d) */
        boolean korrekteReihenfolge = (teile[0][0].istLeerfeld() || teile[dim - 1][dim - 1].istLeerfeld());

        if (!korrekteReihenfolge) {
            return korrekteReihenfolge;
        }

        int[] zahlen = new int[dim * dim - 1];
        int index = 0;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (!teile[i][j].istLeerfeld()) {
                    zahlen[index++] = teile[i][j].getZahl();
                }
            }
        }

        for (int i = 0; i < zahlen.length - 1; i++) {
            if (zahlen[i] > zahlen[i + 1]) {
                return korrekteReihenfolge;
            }
        }
        korrekteReihenfolge = true;
        return korrekteReihenfolge;
    }


    /* public Methoden, die Anfragen nach Informationen von der Klasse
     ZahlButton beantworten oder weiterleiten an die Klasse Schiebepuzzle
     sowie Methoden, die ein Update der Oberflaeche (nach einem Zug oder fuer
     ein neues Spiel) durchfuehren. */

    /* liefert die Anzahl der Zuege von Hauptframe */
    public int getAnzahlZuege() {
        return parent.getAnzahlZuege();
    }

    /* veranlasst die Erhoehung des Zaehlers und ein Neuzeichnen*/
    public void update() {
        parent.erhoeheZugZaehler();
        this.repaint();
    }

    /* veranlasst, dass der Zaehlerwert zurueckgesetzt wird und mischt die 
       Puzzleteile neu */
    public void neuesSpiel() {
        parent.resetZugZaehler();
        this.mischen();
    }

}
