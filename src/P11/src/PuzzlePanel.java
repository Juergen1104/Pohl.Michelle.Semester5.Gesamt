package P11.src;// Michelle Pohl

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

        /* ***  Aufgabenteil (1b)  *** */
        // 1P
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < (n - 1)) || (j < (n - 1))) {
                    this.teile[i][j] = new ZahlButton(count++);
                } else {
                    this.teile[i][j] = new ZahlButton();
                }
            }
        }

        this.mischen();

        this.setLayout(new GridLayout(n, n));
        for (ZahlButton[] zahlButtons : this.teile) {
            for (ZahlButton zahlButton : zahlButtons) {
                zahlButton.addActionListener(new PuzzleActionListener(this));
                this.add(zahlButton);
            }
        }
    }

    private void mischen() {
        int n = 50; // fuer n zufaellige Vertauschungen
        int i, i2, j, j2;
        for (int k = 1; k <= n; k++) {
            do {
                i = (int) (Math.random() * dim);
                j = (int) (Math.random() * dim);
                i2 = (int) (Math.random() * dim);
                j2 = (int) (Math.random() * dim);
            } while ((i == i2) && (j == j2));
            //System.out.println("Tausche [" +  i + "," + j + "] mit [" + i2 + "," + j2 + "]");
            this.teile[i][j].tauscheMit(this.teile[i2][j2]);
        }
    }

    public ZahlButton checkLeerteilNachbar(ZahlButton zb) {
        for (int i = 0; i < this.teile.length; i++) {
            for (int j = 0; j < this.teile[i].length; j++) {
                if (this.teile[i][j] == zb) {
                    for (int[] pos : new int[][]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}}) {
                        int row = pos[0];
                        int col = pos[1];
                        if ((row >= 0) && (row < dim) &&
                                (col >= 0) && (col < dim)) { // korrekte Pos. in Teile Feld
                            if (this.teile[row][col].istLeerfeld()) {
                                return this.teile[row][col];
                            }
                        }
                    }
                    return null;
                }
            }
        }
        return null; // kein Leerteil als Nachbar gefunden
    }

    public boolean fertig() {
        boolean korrekteReihenfolge = true;
        int[] werte = new int[dim * dim - 1];
        int k = 0;
        // alle Nichtleerteile zeilen- und spaltenweise in ein Feld kopieren
        for (int i = 0; i < this.teile.length; i++) {
            for (int j = 0; j < this.teile[i].length; j++) {
                if (!this.teile[i][j].istLeerfeld()) {
                    werte[k] = this.teile[i][j].getZahl();
                    k++;
                }
            }
        }
        // prüfen, ob die Teile in dem Feld in aufsteigender Reihenfolge sind
        int i = 0;
        while ((i < (werte.length - 1)) && korrekteReihenfolge) {
            korrekteReihenfolge &= (werte[i] < werte[i + 1]);
            i++;
        }

        // Leerteil ist entweder oben links oder unten rechts
        korrekteReihenfolge &= (this.teile[0][0].istLeerfeld() ||
                this.teile[this.dim - 1][this.dim - 1].istLeerfeld());

        return korrekteReihenfolge;
    }

    /* public Methoden, die Anfragen nach Informationen  von der Klasse ZahlButton 
     beantworten oder weiterleiten an die Klasse Schiebepuzzle sowie Methoden, die
     ein Update der Oberflaeche (nach einem Zug oder fuer ein neues Spiel) durchfuehren. */

    /* liefert die Anzahl der Zuege von Hauptframe */
    public int getAnzahlZuege() {
        return parent.getAnzahlZuege();
    }

    /* veranlasst die Erhoehung des Zaehlers */
    public void update() {
        parent.erhoeheZugZaehler();
    }

    /* veranlasst, dass der Zaehlerwert zurueckgesetzt wird und mischt die Puzzleteile neu */
    public void neuesSpiel() {
        parent.resetZugZaehler();
        this.mischen();
    }

}
