package P5.src;

// Michelle Pohl
public class Rekursion1 {

    public static void r(int n, int k) {
        if (n > 1) {
            if ((n % k) == 0) {
                System.out.print(k + " ");
                n /= k;
            } else {
                k++;
            }

            r(n, k);
        }
    }

    public static void f(int n) {
        r(n, 2);
        System.out.println();
    }


    /*  Aufgabenteil (c) */

    public static void iterativeF(int n) {
        int k = 2;
        while (n > 1) {
            if (n % k == 0) {
                System.out.print(k + " ");
                n = n / k;
            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int n = IOTools.readInteger("n = ");
        f(n);
    }
}


/*  Aufgabenteil (a)

N: 10647 K: 2
N: 10647 K: 3
N: 3549 K: 3
N: 1183 K: 3
N: 1183 K: 4
N: 1183 K: 5
N: 1183 K: 6
N: 1183 K: 7
N: 169 K: 7
N: 169 K: 8
N: 169 K: 9
N: 169 K: 10
N: 169 K: 11
N: 169 K: 12
N: 169 K: 13
N: 13 K: 13
N: 1 K: 13
Ausgabe: 2 3 3 7 13 13



 */

/*  Aufgabenteil (b)

/*

    Die Methode f(n) gibt die Primfaktorzerlegung der Zahl n aus. Es beginnt mit k = 2 und sucht
    nach den kleinsten Teilern von n, gibt diese aus und teilt n, bis n = 1 erreicht ist. Dabei werden
    folgende Schritte durchlaufen:

        1. Wenn n durch k teilbar ist, wird k ausgegeben und n durch k geteilt.
        2. Ist n%k ungleich  0, wird k um 1 erhöht.
        3. Geht solange bis n = 1 ist.

    Der Algorithmus gibt somit die Primfaktoren der Eingabezahl n in aufsteigender Reihenfolge aus.
 */


