package P7.src;

// Michelle Pohl
public class MagicSquare {
    private Integer[][] mSq;
    private int n;

    // 2
    public MagicSquare(String sq) {
        // WErte in array aufteilen und Anzahl bestimmen
        String[] values = sq.split(",");
        n = (int) Math.sqrt(values.length);

        mSq = new Integer[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mSq[i][j] = Integer.valueOf(values[index++]); // Verwende Integer.valueOf, um Autoboxing zu vermeiden
            }
        }
    }

    public static void main(String[] args) {
        String sq1 = "2,7,6,9,5,1,4,3,8";
        String sq2 = "15,10,3,6,4,5,16,9,14,11,2,7,1,8,13,12";
        String sq3 = "1,2,3,4";
        String sq4 = "1,1,1,1,1,1,1,1,1";

        for (String s : new String[]{sq1, sq2, sq3, sq4}) {
            System.out.println();
            MagicSquare mSq = new MagicSquare(s);
            mSq.printSquare();
            if (mSq.checkSquare() && mSq.checkSquare2()) {
                System.out.println("\n... is a magic square\n");
            } else {
                System.out.println("\n... is NO magic square\n");
            }
        }

    }

    // 1
    public void printSquare() {
        for (Integer[] row : mSq) {
            for (Integer value : row) {
                System.out.print(String.format("%3d", value));
            }
            System.out.println();
        }
    }

    // 1
    private int sumArr(Integer[] arr) {
        int sum = 0;
        for (Integer value : arr) {
            sum += value; // Verwendet intValue() für Summierung ohne Autounboxing
        }
        return sum;
    }

    // 3
    public boolean checkSquare() {

        Integer[] arr1 = new Integer[this.n];
        Integer[] arr2 = new Integer[this.n];

        int targetSum = sumArr(mSq[0]);

        for (int i = 1; i < n; i++) {
            if (sumArr(mSq[i]) != targetSum) {
                return false;
            }
        }

        for (int j = 0; j < n; j++) {
            Integer[] column = new Integer[n];
            for (int i = 0; i < n; i++) {
                column[i] = mSq[i][j];
            }
            if (sumArr(column) != targetSum) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            arr1[i] = mSq[i][i];
            arr2[i] = mSq[i][n - i - 1];
        }
        return sumArr(arr1) == targetSum && sumArr(arr2) == targetSum;
    }

    // 2
    public boolean checkSquare2() {

        int maxVal = n * n;

        for (int i = 1; i <= maxVal; i++) {
            Integer target = i;
            boolean gefunden = false;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (mSq[row][col].equals(target)) {
                        gefunden = true;
                        break;
                    }
                }
                if (gefunden) break;
            }

            // Nicht gefunden
            if (!gefunden) {
                return false;
            }
        }

        // Alle Zahlen gefunden
        return true;

    }
}
