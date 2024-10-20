package P5.src;

//  Michelle POhl
public class Liste {
	
    private Listenelement head;
    private Listenelement z;
	
    // leere Liste erzeugen
    public Liste(){
	head = new Listenelement();
	z = new Listenelement();
	head.data = null;
	head.next = z;
	z.data = null;
	z.next = z;
    }
	
    // Ausgabe aller Elemente der Liste
    public void print(){
	Listenelement ele = head.next;
	while (ele != z){
	    ele.data.print();
	    ele = ele.next;
	}
    }

    // Länge der Liste bestimmen: iterativ
    private int length(){
	int count = 0;
	Listenelement help = head.next;
	
	while (help != z){
	    ++count;
	    help = help.next;
	}

	return count;
    }
    
    // neues Element mit dem als Parameter übergebenen Daten-Obkekt 
    // am Kopf der Liste einfügen
    public void insert(Ausgabe dataEle){
	Listenelement newEle = new Listenelement();
	newEle.data = dataEle; // nur Referenzkopie
	newEle.next = head.next;
	head.next = newEle;
    }


    /* *** Aufgabenteil (a) *** */
    
    public double getSummeAusgaben(){

		double summe = 0.0;
		Listenelement ele = head.next;
		while (ele != z) {
			summe += ele.data.getBetrag();  // Summe
			ele = ele.next;
		}
		return summe;
    }

    /* *** Aufgabenteil (b) *** */
    public Liste getAusgabenListeMonat(String monat){

		Liste neueListe = new Liste();
		Listenelement ele = head.next;
		while (ele != z) {
			if (ele.data.istImMonat(monat)) {
				neueListe.insert(ele.data);
			}
			ele = ele.next;
		}
		return neueListe;

    }



    /* *** Aufgabenteil (c) *** */
	public void sort() {
		int n = length(); // Länge der Liste
		for (int i = 0; i < n - 1; i++) {
			Listenelement e1 = head.next;
			Listenelement e2 = e1.next;
			while (e2 != z) {
				// Wenn das erste Element größer ist, tauschen
				if (e1.data.getTag() > e2.data.getTag()) {
					tausche(e1, e2);  // Daten der Listenelemente tauschen
				}
				e1 = e2;
				e2 = e2.next;
			}
		}
	}
	private void tausche(Listenelement e1, Listenelement e2) {
		Ausgabe temp = e1.data;
		e1.data = e2.data;
		e2.data = temp;
	}



 
    /* *** Aufgabenteil (d) *** */

	public void sort2() {
		int n = length();
		for (int i = 0; i < n - 1; i++) {
			Listenelement p = head; // Zeigt auf das Element vor e1
			Listenelement e1 = head.next;
			Listenelement e2 = e1.next;
			while (e2 != z) {
				if (e1.data.getTag() > e2.data.getTag()) {
					tausche(p, e1, e2);
				}
				p = e1;
				e1 = e2;
				e2 = e2.next;
			}
		}
	}

	// Methode zum Tauschen der Listenelement-Referenzen
	private void tausche(Listenelement p, Listenelement e1, Listenelement e2) {
		p.next = e2;
		e1.next = e2.next;
		e2.next = e1;
	}
 


}
