package P5.src;

public class Ausgabe {
    private double betrag;
    private int tag;
    private String monat;
    private String inhalt;   // Beschreibung

    public Ausgabe(int t, String m, double b, String o){
	tag = t;
	monat = m;
	betrag = b;
	inhalt = o;
    }

    public String getInhalt(){
	return inhalt;
    }

    public double getBetrag(){
	return betrag;
    }

    public int getTag(){
	return tag;
    }
    
    public String getMonat(){
	return monat;
    }
 
    public void print(){
	System.out.println(tag + ". " +  monat + ": " + 
			   betrag + " (" + inhalt + ")");
    }

    /* Vergleich der Stringgs fuer den Monat der (aktuellen) Ausgabe-Instanz
       und dem als Parameter uebergebenen String.
       sind die beiden Strings identisch, wird true zurueckgegeben,
       ansonsten false
     */
    public boolean istImMonat(String mName){
	return monat.equals(mName);
    }

}
 
