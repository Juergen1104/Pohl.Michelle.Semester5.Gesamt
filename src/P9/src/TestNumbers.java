package P9.src;// Michelle Pohl
import java.util.Random;

public class TestNumbers {

    /* Aufgabenteil (a) */
    public static void print(java.lang.Number[] numbers) {

        for (java.lang.Number number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /* Aufgabenteil (b) */
    public static void sort(java.lang.Number[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j].compareTo(numbers[j + 1]) > 0) {
                    java.lang.Number temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int k = 10;
        java.lang.Number[] brueche = new java.lang.Number[k];

        /* Aufgabenteil (d) */

        Random random = new Random();

        for (int i = 0; i < brueche.length; i++) {
            int z = random.nextInt(20) + 1;
            int n = random.nextInt(20) + 1;

            brueche[i] = new Bruch(z,n);
        }

        print(brueche);
        sort(brueche);
        print(brueche);
    }
}
