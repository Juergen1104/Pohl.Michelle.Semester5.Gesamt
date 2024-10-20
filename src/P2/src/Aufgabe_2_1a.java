package P2.src;//Michelle Pohl

public class Aufgabe_2_1a {
    /* *** Aufgabenteil (a)  *** */
	/*
	    Die Funktion f1(a, b) zählt die ganzen Zahlen im Bereich von a bis b , die durch 4 teilbar sind.
        Die Funktion könnte also wie folgt beschrieben werden:
        f1(a,b) = Anzahl der Werte von i im Bereich [a, b], für die gilt: i%4 == 0
	 */


    public static void main(String[] args) {

        int a = IOTools.readInteger("a = ");
        int b = IOTools.readInteger("b = ");
        int r1 = 0;

        for (int i = a; i <= b; i++) {
            switch (i % 4) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    r1++;
                    break;
            }
        }
        System.out.println("r1 = " + r1);
    }
}
