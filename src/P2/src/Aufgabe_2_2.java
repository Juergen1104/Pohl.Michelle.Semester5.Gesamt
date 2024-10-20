package P2.src;//Michelle Pohl

public class Aufgabe_2_2 {
    // Aufgabenteil (a) 
    // 1 2 5 14 41 122 ...
    // Schema: 
    public static void folge_a() {
        int a = 1;
        System.out.print(a);

        for (int n = 1; n < 15; n++) {
            a = 3 * a - 1;
            System.out.print(", " + a);
        }
        System.out.println();
    }

    // Aufgabenteil (b)
    // 3 4 2 5 1 6 0 7   ...

    // addiere den schleifenzähler wenn dieser ungerade ist, ansonsten subraier diesen

    // Schema:
    public static void folge_b() {
        int a = 3; // Start

        System.out.print(a);

        for (int n = 1; n < 15; n++) {
            if (n % 2 == 1) {
                a = a + n;  // Ungerade , also +
            } else {
                a = a - n;  // Gerade, also -
            }
            System.out.print(", " + a);
        }
        System.out.println();
    }

    // Aufgabenteil (c)
    // 12 6 3 8 4 2 1 6
    // Schema: wenn a gerade, dann geteilt 2, sonst + 5
    public static void folge_c() {

        int a = 12;
        System.out.print(a); // Erstes Element ausgeben

        for (int n = 1; n < 15; n++) {
            if (a % 2 == 0) {
                a = a / 2;
            } else {
                a = a + 5;
            }
            System.out.print(", " + a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Aufgabenteil (a)");
        folge_a();  // erste Folge berechnen und ausgeben
        System.out.println("\nAufgabenteil (b)");
        folge_b();  // zweite Folge berechnen und ausgeben
        System.out.println("\nAufgabenteil (c)");
        folge_c();  // dritte Folge berechnen und ausgeben
        System.out.println();
    }
}
