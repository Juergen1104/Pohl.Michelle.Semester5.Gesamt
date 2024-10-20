package P4.src;

// Michelle Pohl
public class WuerfelTest {
    public static void main(String[] args) {
        int n = 3;
        Wuerfel[] wuerfel = new Wuerfel[n];

        /* *** Aufgabenteil (b) *** */

        for (int i = 0; i < n; i++) {
            wuerfel[i] = new Wuerfel();
            wuerfel[i].print();
        }


        System.out.println("---------------");

// 3-maliges Würfeln und Ausgeben der neuen Werte
        for (int durchgang = 1; durchgang <= 3; durchgang++) {
            System.out.println(durchgang + ". Wuerfeln:");
            for (int i = 0; i < n; i++) {
                wuerfel[i].werfen();
                wuerfel[i].print();
            }
        }
    }
}
