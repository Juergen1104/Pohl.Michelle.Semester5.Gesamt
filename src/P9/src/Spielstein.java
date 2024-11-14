package P9.src;

import java.awt.*;

public class Spielstein {
    /* Konstanten für max. 4 verschiedene Spieler */
    private static final Color rot = Color.red;
    private static final Color gelb = Color.yellow;
    private static final Color blau = Color.blue;
    private static final Color gruen = Color.green;
    private static final Color[] farben = {rot,gelb,blau,gruen};
    
    /* Ausgabesymbole für max. 4 verschiedene Spieler */
    private final static char[] zeichen = {'X','O','A','V'};

    private Color sFarbe;
    private char sZeichen;
    private Spieler spieler;

    /* generiert einen Spielstein für einen bestimmten Spieler.
       Die ID (Spielernummer) muss dabei zwischen 1 und 4 liegen.
       Abhaengig von der ID wird dem Spielstein eine Farbe sowie
       ein Zeichen (bei Ausgabe auf der Kommandozeile) zugeordnet.
     */
    public Spielstein (Spieler spieler){
	this.spieler = spieler;
	int id = spieler.getID();
	sZeichen = zeichen[id-1];
	sFarbe = farben[id-1];
    }

    /* Diese Methode gibt den Spieler (die Spielerinstanz), die diesem
     * Spielstein zugeordnet ist.
     */
    public Spieler getSpieler(){
	return this.spieler;
    }

    /* Diese Methode gibt die Farbe dieses Spielsteins zurueck.
     */
    public Color getFarbe(){
	return this.sFarbe;
    }

    /* Diese Methode gibt das Zeichen zurueck, welches diesem
     *  Spielstein zwecks Repraesentation auf der Kommandozeile 
     * zugeordnet ist, zurueck.
     */
    public char getZeichen(){
	return this.sZeichen;
    }

    /* 
     * String-Repraesentation: entspricht dem Attribut Zeichen 
     */
    public String toString(){
	return "" + this.sZeichen;
    }

    /* Die Methode eberprueft, ob ein Spielstein dem gleichen Spieler 
     * gehoert wie der als Parameter uebergebene Spielstein. 
     * Ist dies der Fall, wird true zurueckgegeben, ansonsten false.
     */
    public boolean gleicherSpieler (Spielstein sp2){
	return (sp2 != null) && (this.spieler.getID() == sp2.spieler.getID());
    }
    
}
