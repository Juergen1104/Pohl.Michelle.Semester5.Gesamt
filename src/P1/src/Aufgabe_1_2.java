package P1.src;

public class Aufgabe_1_2 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;


        /*  Aufgabenteil (a)

        1.) b * c -> 2 * 3 = 6
        2.) d / b -> 4 / 2 = 2
        3.) a + 6 - 2 -> 1 + 6 - 2 = 5

            Ergebnis = 5
         */

        int ergebnis = a + b * c - d / b;
        System.out.println(ergebnis);

        a = 1;
        b = 2;
        c = 3;
        d = 4; // reinitialisieren


        /* Aufgabenteil (b)

        1.) a++ -> 1 (a wird jetzt 2)
        2.) ++a -> 3 (a wird jetzt 3)
        3.) a -> 3
        4.) 1 + 2 + 3 + 2 = 8

         Ergebnis = 8

         */
        ergebnis =  a + a++ + ++a + a;
        System.out.println(ergebnis);

        a = 1;
        b = 2;
        c = 3;
        d = 4; // reinitialisieren


        /* Aufgabenteil (c)

        1.) ++c -> 4 (c wird jetzt 4)
        2.) b += 4 -> 2 + 4 = 6 (b wird jetzt 6)
        3.) a -= 6 -> 1 - 6 = -5 (a wird jetzt -5)
        Ergebnis -5

         */

        ergebnis = a -= b += ++c;
        System.out.println(ergebnis);

        a = 1;
        b = 2;
        c = 3;
        d = 4;  // reinitialisieren

        /*  Aufgabenteil (d)

        1.) a * d -> -5 * 4 = -20
        2.) b * c -> 6 * 4 = 24
        3.) -20 < 24 -> true (linke Seite)

         */

        boolean ergebnisTF = a * d < b * c || a + d != b + c;
        System.out.println(ergebnisTF);

        a = 1;
        b = 2;
        c = 3;
        d = 4;      //  reinitialisieren

        /* Aufgabenteil (e)
        1.) -1 * a + b -> -1 * 1 + 2 = 1
        2.) d - c -> 4 - 3 = 1
        3.) 1 < 1 -> false
        4.) ++a * ++a -> 0
        Ergebnis = 6

         */
         ergebnis = !(-1 * a + b < d - c) ? ++a * ++a : c++ + ++c;
        System.out.println(ergebnis);

        a = 1;
        b = 2;
        c = 3;
        d = 4;   //  reinitialisieren

        /* Aufgabenteil (f)

        1.) h1 = ((a > b) ? b : a) -> h1 = 1
        2.) h2 = ((c > d) ? d : c) -> h2 = 3
        3.) 4 > 4 -> false
        4.) Ergebnis ist h1 -> 1
        Ergebnis = 1

         */
        int h1, h2;

        h1 = ((a > b) ? b : a);
        h2 = ((c > d) ? d : c);


        ergebnis =  (h1 = ((a > b) ? b : a)) > (h2 = ((c > d) ? d : c)) ? h2 : h1;
        System.out.println(ergebnis);
    }
}


