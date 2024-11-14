package P9.src;

// Michelle Pohl
public class VierGewinntBrett extends Spielbrett {

    public VierGewinntBrett(int anzZeilen, int anzSpalten) {
        super(anzSpalten, anzZeilen);
    }

    @Override
    public boolean zugMoeglich(Spieler spieler) {
        // Prüfen, ob es mindestens ein freies Feld gibt
        for (int i = 0; i < anzZeilen; i++) {
            for (int j = 0; j < anzSpalten; j++) {
                if (belegung[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Spieler gewinnsituation() {
        // horizontal prüfen

        for (int i = 0; i < anzZeilen; i++) {
            for (int j = 0; j < anzSpalten - 3; j++) {
                if (belegung[i][j] != null &&
                        belegung[i][j].gleicherSpieler(belegung[i][j + 1]) &&
                        belegung[i][j].gleicherSpieler(belegung[i][j + 2]) &&
                        belegung[i][j].gleicherSpieler(belegung[i][j + 3])) {
                    return belegung[i][j].getSpieler();
                }
            }
        }

        // vertikal prüfen
        for (int i = 0; i < anzZeilen - 3; i++) {
            for (int j = 0; j < anzSpalten; j++) {
                if (belegung[i][j] != null &&
                        belegung[i][j].gleicherSpieler(belegung[i + 1][j]) &&
                        belegung[i][j].gleicherSpieler(belegung[i + 2][j]) &&
                        belegung[i][j].gleicherSpieler(belegung[i + 3][j])) {
                    return belegung[i][j].getSpieler();
                }
            }
        }

        // diagonal rechts prüfen
        for (int i = 0; i < anzZeilen - 3; i++) {
            for (int j = 0; j < anzSpalten - 3; j++) {
                if (belegung[i][j] != null &&
                        belegung[i][j].gleicherSpieler(belegung[i + 1][j + 1]) &&
                        belegung[i][j].gleicherSpieler(belegung[i + 2][j + 2]) &&
                        belegung[i][j].gleicherSpieler(belegung[i + 3][j + 3])) {
                    return belegung[i][j].getSpieler();
                }
            }
        }
        // und links
        for (int i = 3; i < anzZeilen; i++) {
            for (int j = 0; j < anzSpalten - 3; j++) {
                if (belegung[i][j] != null &&
                        belegung[i][j].gleicherSpieler(belegung[i - 1][j + 1]) &&
                        belegung[i][j].gleicherSpieler(belegung[i - 2][j + 2]) &&
                        belegung[i][j].gleicherSpieler(belegung[i - 3][j + 3])) {
                    return belegung[i][j].getSpieler();
                }
            }
        }

        return null;
    }

    @Override
    public boolean hinzufuegen(Spieler spieler, int spalte, int zeile) {
        if (spalte < 0 || spalte >= anzSpalten) {
            return false;
        }

        for (int i = 0; i < anzZeilen; i++) {
            if (belegung[i][spalte] == null) {
                belegung[i][spalte] = new Spielstein(spieler);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean entfernen(Spieler spieler, int spalte, int zeile) {
        return false;
    }

    @Override
    public boolean bewegen(Spieler spieler, int vonSpalte, int vonZeile, int nachSpalte, int nachZeile) {
        return false;
    }

    @Override
    public void zeichnen() {
        super.zeichnen();
        for (int j = 1; j <= anzSpalten; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
