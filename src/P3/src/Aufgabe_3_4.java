package P3.src;// Michelle Pohl
import java.awt.image.BufferedImage;

public class Aufgabe_3_4 {
    // 4P

    public static void main(String[] args) {
        int W = 360;  // Breite des Bilds = Anzahl Spalten
        int H = 220;  // Hoehe des Bilds  = Anzahl Zeilen

        // Bild mit H Zeilen und W Spalten
        int[][] ffData = new int[H][W];

        int blue = -16777003; // int Wert der Farbe (r=0,g=0,b=213)
        int white = -1;       // int Wert der Farbe (r=255,g=255,b=255)

        // hier Code einfügen....

        // erst mal alles weiss
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ffData[i][j] = white;
            }
        }

        // blaue horizontales Rechteck
        for (int i = 80; i < 140; i++) {
            for (int j = 0; j < W; j++) {
                ffData[i][j] = blue;
            }
        }

        // blaue horizontales Rechteck
        for (int i = 0; i < H; i++) {
            for (int j = 100; j < 160; j++) {
                ffData[i][j] = blue;
            }
        }

        // Bild in Datei schreiben
        BufferedImage finFlag = ImageTools2.createImage(ffData);
        ImageTools2.writeImage(finFlag, "finnland.png");

    }
}
