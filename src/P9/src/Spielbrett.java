package P9.src;

public abstract class Spielbrett {
    protected int anzZeilen,anzSpalten;
    protected Spielstein[][] belegung;
    protected int anzSteine = 0;

    public Spielbrett(int anzSpalten, int anzZeilen){
	this.anzZeilen = anzZeilen;
	this.anzSpalten = anzSpalten;
	belegung = new Spielstein[anzZeilen][anzSpalten];
    }

    /* Ausgabe des Spielbretts mit den Spielsteinen in der 
     * Konsole 
     */
    public void zeichnen(){
	for (int i=anzZeilen-1;i>=0;i--){
	    for (int j=0;j<anzSpalten;j++){
		Spielstein stein = belegung[i][j];
		if (stein != null){
		    System.out.print(stein);
		} else {
		    System.out.print('_');
		}
		System.out.print(" ");
	    }
	    System.out.println();
	}
	System.out.println();

    }

    /* Diese Methode soll pruefen, ob der als Parameter uebergebene Spieler
     * Spieler noch einen Zug machen kann. Der Wert des Parameters spieler
     * kann null sein, wenn die Moeglichkeit eines Zugs unabhaengig vom 
     * Spieler ist.
     */
    public abstract  boolean zugMoeglich(Spieler spieler);

    /* Diese Methode soll pruefen, ob eine Gewinnsituation vorliegt. Ist dies
     * der Fall, soll die Spieler-Instanz des jeweiligen Gewinners 
     * zurueckgegeben werden, ansonsten der Wert null.
     */
    public abstract Spieler gewinnsituation();

    /* Diese Methode soll einen neuen Spielstein fuer den als 
     * Parameter uebergebenen Spieler generieren und ihn in 
     * einer bestimmten Zeile und/oder Spalte hinzuzufügen. 
     * Der Wert -1 fuer einen der Parameter spalte oder zeile
     * kann verwendet werden, wenn dieser nicht benoetigt wird.
     * Wenn es moeglich (regelkonform) ist, einen Stein an der
     * angegebenen Stelle einzufuegen, soll diese Aktion durchgefuehrt
     * und der Wert true zurueckgegeben werden, ansonsten geschieht
     * nichts und der Wert false soll zurueckgegeben werden.
     */
    public abstract boolean hinzufuegen(Spieler spieler, int spalte, int zeile);

    
    /* Diese Methode soll einen bestimmten Spielstein vom Spielbrett
     * entfernen (löschen). Hierbei soll zunaechst geprueft werden,
     * ob diese Aktion regelkonform ist. Wenn ja, wird die Loeschung
     * vorgenommen und der Wert true zurueckgegeben, ansonsten der Wert
     * false.
     */
    public abstract boolean entfernen(Spieler spieler, int spalte, int zeile);

    /* Diese Methode soll einen Spielstein eines Spielers auf dem 
     * Spielbrett von einer Position (Zeile,Spalte) zu einer 
     * anderen bewegen. Hierbei soll zunaechst geprueft werden, 
     * ob diese Aktion regelkonform ist. 
     * Wenn ja, wird sie durchgefuehrt und der Wert true zurueckgeben,
     * ansonsten der Wert
     * false.
     */ 
    public abstract boolean bewegen(Spieler spieler, int vonSpalte, int vonZeile, int nachSpalte, int nachZeile);

}
