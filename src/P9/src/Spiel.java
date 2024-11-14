package P9.src;

public abstract class Spiel {
    protected Spielbrett brett;
    protected Spieler[] spieler;

    /* Initialisiert ein Spiel mit einem konkreten Spielbrett
     * fuer eine feste Anzahl von Spielern mit einer festen
     * Anzahl von Spielsteinen für jeden Spieler.
     */
    public Spiel(int anzSpieler, Spielbrett brett, int anzSteine){
	this.brett = brett;
	spieler = new Spieler[anzSpieler];
	for (int i=1;i<=anzSpieler;i++){
	    spieler[i-1] = new Spieler(i,anzSteine);
	}
    }

    /* Diese Methode dient dazu, einen Spielzug eines Spielers
     * auszufuehren. Hierzu wird das Attribut brett verwendet.
     */
    public abstract void ziehen(Spieler spieler);


    /* Diese Methode implementiert den generellen Spielablauf.
     * Die Spieler ziehen abwechselnd, solange noch Zuege
     * moeglich sind. Tritt nach einem Zug eine Gewinnsituation
     * ein, wird das Spiel abgebrochen und der Gewinner ausgegeben.
     * Dazu wird nach jedem Zug das Spielfeld mit der aktuellen
     * Belegung durch die Spielsteine ausgegeben.
     */
    public void spielen(){
	Spieler gewinner = null;
	this.brett.zeichnen();
	do{
	    for (int i=0;i<this.spieler.length;i++){
		ziehen(spieler[i]);
		this.brett.zeichnen();
		gewinner = this.brett.gewinnsituation();
		if (gewinner != null){
		    break;
		}
	    }
	} while ((gewinner == null) && (this.brett.zugMoeglich(null)));
	
	System.out.println(gewinner +  " hat gewonnen.");
    }

}
