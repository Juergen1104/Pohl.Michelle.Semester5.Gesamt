package P11.src;// Michelle Pohl

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ZahlButton extends JButton {
    private int zahl;

    /* Konstruktor fuer Teile mit Zahl (1 - 15) */
    public ZahlButton(int zahl) {
        super(String.valueOf(zahl));
        this.setBackground(Color.orange);
        this.setFont(this.getFont().deriveFont(20.0f));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.zahl = zahl;
    }

    /* Konstruktor fuer Leerfeld */
    public ZahlButton() {
        this(0);
        this.setText("");
    }

    /* gibt Zahl des Teils zurueck */
    public int getZahl() {
        return this.zahl;
    }

    /* setzt Zahl auf Parameterwert und aktualisiert Buttonaufschrift */
    private void setZahl(int zahl) {
        this.zahl = zahl;
        if (zahl != 0) {
            this.setText(String.valueOf(this.zahl));
        } else {
            this.setText("");
        }
    }

    /* prueft, ob die Instanz ein Leerteil (Zahl ist 0) repraesentiert */
    public boolean istLeerfeld() {
        return (this.zahl == 0);
    }

    /* tauscht Inhalt (Zahl und Beschriftung) dieses Buttons mit dem
     * des als Parameter uebergebenen Buttons */
    public void tauscheMit(ZahlButton b2) {
        int hilf = this.zahl;
        this.setZahl(b2.zahl);
        b2.setZahl(hilf);
    }
}
