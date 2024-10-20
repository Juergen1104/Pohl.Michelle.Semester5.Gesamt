package P2.src;//Michelle Pohl

public class Aufgabe_2_5 {
    public static void main(String[] args) {
        double a;

        // Eingabe der Zahl
        do {
            a = IOTools.readDouble("a = ");
        } while (a <= 0);

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("o");
                if (j < a - 1) {
                    System.out.print("-");
                }
            }
            System.out.println();

            if (i < a - 1) {
                for (int j = 0; j < a; j++) {
                    System.out.print("| ");
                }
                System.out.println();
            }
        }
    }

}
