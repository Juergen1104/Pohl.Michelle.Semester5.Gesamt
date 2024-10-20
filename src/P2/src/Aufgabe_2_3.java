package P2.src;//Michelle Pohl

public class Aufgabe_2_3 {
    public static void main(String[] args) {
        int h;

        // Prompt the user for input and ensure it is within [3, 26]
        do {
            System.out.print("Please enter a value for h (between 3 and 26): ");
            h = IOTools.readInteger();
        } while (h < 3 || h > 26);

        for (int i = 1; i <= h; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }

        for (int i = h - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }
}


