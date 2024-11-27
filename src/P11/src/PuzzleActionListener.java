package P11.src;// Michelle Pohl

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleActionListener implements ActionListener {
    private PuzzlePanel parent; // Referenz auf das PuzzlePanel

    // Konstruktor: Initialisiert die Referenz auf das PuzzlePanel
    public PuzzleActionListener(PuzzlePanel parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ermitteln des ZahlButton-Objekts, das das Event ausgelöst hat
        ZahlButton clickedButton = (ZahlButton) e.getSource();

        // Nachbar-Leerfeld prüfen
        ZahlButton emptyNeighbor = parent.checkLeerteilNachbar(clickedButton);
        if (emptyNeighbor != null) { // Es gibt einen Leerfeld-Nachbarn
            // Inhalte tauschen
            clickedButton.tauscheMit(emptyNeighbor);

            // Spielzustand aktualisieren
            parent.update();

            // Prüfen, ob das Puzzle fertig ist
            if (parent.fertig()) {
                int moves = parent.getAnzahlZuege(); // Anzahl der Züge
                // Erfolgsmeldung anzeigen
                int response = JOptionPane.showConfirmDialog(
                        parent,
                        "Herzlichen Glückwunsch! Sie haben das Puzzle in " + moves + " Zügen gelöst.\n" +
                                "Möchten Sie ein neues Spiel starten?",
                        "Spiel beendet",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Benutzerentscheidung auswerten
                if (response == JOptionPane.YES_OPTION) {
                    parent.neuesSpiel(); // Neues Spiel starten
                } else {
                    System.exit(0); // Programm beenden
                }
            }
        }
    }
}
