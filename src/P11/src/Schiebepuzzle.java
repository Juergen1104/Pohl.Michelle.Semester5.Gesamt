package P11.src;// Michelle Pohl
import javax.swing.*;
import java.awt.*;

public class Schiebepuzzle extends JFrame {
    private final static Font font = new Font(null, Font.BOLD, 16);
    private int anzahlZuege = 0;    // Hoehen und Breiten der einzelnen Panel
    private int w = 400, h1 = 50, h2 = w;
    private JLabel anzZuegeLabel;
    public Schiebepuzzle() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createComponents();
        this.setLocation(50, 50);
        this.pack();
    }

    public static void main(String[] args) {
        Schiebepuzzle gui = new Schiebepuzzle();
        gui.setVisible(true);


    }

    private void createComponents() {
        Container c = this.getContentPane();
        JPanel p1 = this.createAnzeigePanel();  // Label mit Anzahl der Züge
        JPanel p2 = this.createPuzzlePanel();   // Raster mit ZahlButtons
        for (JPanel p : new JPanel[]{p1, p2}) {
            p.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        }

        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
    }

    /* generiert und konfiguriert ein Panel mit dem ZaehlerLabel */
    private JPanel createAnzeigePanel() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(w, h1));
        p.setBackground(Color.BLACK);
        this.anzZuegeLabel = new JLabel("0", JLabel.CENTER);
        this.anzZuegeLabel.setFont(this.font);
        this.anzZuegeLabel.setBackground(Color.orange);
        this.anzZuegeLabel.setOpaque(true);
        this.anzZuegeLabel.setPreferredSize(new Dimension(50, 25));
        this.anzZuegeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p.add(anzZuegeLabel);
        return p;
    }

    // generiert das Panel fuer das Spielfeld */
    private JPanel createPuzzlePanel() {
        int n = 4;
        JPanel p = new PuzzlePanel(this, n);
        p.setBackground(Color.BLACK);
        p.setPreferredSize(new Dimension(w, w));
        return p;
    }

    /* public Methoden, die PuzzlePanel Instanz Informationen liefern
       bzw. Attribute in dieser Klasse setzen 
     */

    /* liefert aktuelle Anzahl von Zuegen */
    public int getAnzahlZuege() {
        return this.anzahlZuege;
    }

    /* muss fuer jeden Zug des Spielers aufgerufen werden:
       erhoeht anzahlZuege um 1 */
    public void erhoeheZugZaehler() {
        this.anzahlZuege++;
        this.anzZuegeLabel.setText(String.valueOf(this.anzahlZuege));
    }

    /* stellt Anfangszustand fuer Zaehler label anzahlZuege wieder her
     */
    public void resetZugZaehler() {
        this.anzahlZuege = 0;
        this.anzZuegeLabel.setText("0");
        this.anzZuegeLabel.repaint();
    }
}
