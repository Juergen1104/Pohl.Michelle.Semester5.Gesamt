package P2.src;//Michelle Pohl

public class Aufgabe_2_1b {
    public static void main(String[] args){
	/* *** Aufgabenteil (b)  *** */
	/* 
	Die Funktion r2 berechnet die Summe von "Paaren" (oberes und unteres Element),
	die sich durch die Schleife aufeinander zu bewegen. Wenn es eine ungerade Anzahl
	von Elementen gibt, wird der mittlere Wert noch einmal hinzugefügt
	 */
	int n = IOTools.readInteger("n = ");
	int a = n;
	int b = 1;
	int r2 = 0;
	
	while (a > b){
	    r2 += (a + b);
	    a--;
	    b++;
	}
	if (a == b){
	    r2 += a;
	}
	System.out.println("r2 = " +  r2);
    }
}
