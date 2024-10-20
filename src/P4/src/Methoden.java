package P4.src;

// Michelle Pohl
public class Methoden {

    /* *** Aufgabenteil (a) *** */

    // Methode zur Bestimmung der Mehrheit unter drei booleschen Werten
    public static boolean mehrheit(boolean v1, boolean v2, boolean v3) {
        return (v1 && v2) || (v1 && v3) || (v2 && v3);
    }

    public static void testMehrheit() {
        boolean[] values = {true, false};

        System.out.println("Test für mehrheit:");

        for (boolean v1 : values) {
            for (boolean v2 : values) {
                for (boolean v3 : values) {
                    if (mehrheit(v1, v2, v3)) {
                        System.out.println("v1 = " + v1 + " v2 = " + v2 + " v3 = " + v3);
                    }
                }
            }
        }
        System.out.println();

    }

    /* *** Aufgabenteil (b) *** */

    // Methode zur Überprüfung, ob ein Array monoton steigend ist
    public static boolean monoton(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void testMonoton() {
        int[] a = {-1, 0, 1};
        int[] b = {2, 2, 2, 2};
        int[] c = {-1, -2, -3};
        int[] d = {3, 2};
        int[] e = {0};

        int[][] arrays = {a, b, c, d, e};

        System.out.println("Test für monoton:");

        // Schleife durch das zweidimensionale Array
        for (int[] array : arrays) {
            // Ausgabe des Arrays
            System.out.print("Die Folge ");
            for (int num : array) {
                System.out.print(num + " ");
            }

            if (monoton(array)) {
                System.out.println("steigt monoton.");
            } else {
                System.out.println("steigt nicht monoton.");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testMehrheit();
        testMonoton();
    }
}
