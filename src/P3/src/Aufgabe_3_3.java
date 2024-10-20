package P3.src;

// Michelle Pohl
public class Aufgabe_3_3 {

    public static void main(String[] args) {
        int N = 11;
        char[][] matrix = new char[N][N];

        int mitte = N / 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // Rand = *
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    matrix[i][j] = '*';
                }
                // Mitte
                else if (i == mitte) {
                    matrix[i][j] = '-';
                }
                // Mittlere Spalte mit '|'
                else if (j == mitte) {
                    matrix[i][j] = '|';
                }
                // Linker oberer Quadrant mit '.'
                else if (i < mitte && j < mitte) {
                    matrix[i][j] = '.';
                }
                // Rechter unterer Quadrant mit '.'
                else if (i > mitte && j > mitte) {
                    matrix[i][j] = '.';
                }
                // Rechter oberer Quadrant mit '+'
                else if (i < mitte) {
                    matrix[i][j] = '+';
                }
                // Linker unterer Quadrant mit '+'
                else {
                    matrix[i][j] = '+';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }

}

