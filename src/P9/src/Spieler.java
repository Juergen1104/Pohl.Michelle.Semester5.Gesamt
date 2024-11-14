package P9.src;

public class Spieler{
    private int nr;  // eindeutige Spielernummer (ID)
    private int maxSteine; // maximale Zahl an Spielsteinen
    private int anzSteine; // aktuell noch einsetzbare Spielsteine

    /* Generiert eine Spielerinstanz mit einer (eindeutigen) 
     * Spielernummer, die als ID dient.
     * Die Eindeutigkeit der Nummer muss von außen gewährleistet werden.
     */
    public Spieler(int nr, int anzSteine){
	this.nr = nr;
	this.maxSteine = anzSteine;
	this.anzSteine = this.maxSteine;
    }

    /* Hier wird ein neuer Spielstein vom Spieler angefordert.
     * Der Stein wird dabei dem Spieler zugeordnet und die Anzahl
     * der noch zu Verfügung stehenden Steine wird dabei reduziert.
     * Wenn diese Anzahl zu Beginn bereits 0 ist, wird der Wert
     * null zurückgegeben
     */
    public Spielstein neuenSpielstein(){
        if (anzSteine > 0) {
            anzSteine--;
            return new Spielstein(this);
        } else {
            return null;
        }
    }

    /* String-Reprasentation des Spielers 
     */
    public String toString(){
	return "Spieler Nr. " + this.nr;
    }

    /* Die Methode gibt die (eindeutige) Spieler-ID zurueck
    */
    public int getID(){
	return this.nr;
    }

    /* Gibt die Anzahl der noch aktuell einsetzbaren Spielsteine 
     * zurueck.
     */
    public int anzahlSteine(){
	return this.anzSteine;
    }
}
