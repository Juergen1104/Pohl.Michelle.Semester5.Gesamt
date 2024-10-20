package P3.src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageTools2 {

    /* Generiert ein Farbbild (RGB) aus einem zweidimensionalen Feld
       von int-Werten. Es wird vorausgesetzt, dass alle Zeilen die gleiche Laenge
       haben.
       Das Bild wird als Ergebnis zurückgegeben.
    */
     public static BufferedImage createImage(int[][] data){
	BufferedImage img = new BufferedImage(data[0].length, data.length,
                                              BufferedImage.TYPE_INT_RGB);
	for (int i=0;i<data.length;i++){
	    for (int j=0;j<data[0].length;j++){
		img.setRGB(j,i,data[i][j]);
	    }
	}
		
	return img;
     }
    
    /* schreibt das Bild mit dem Namen filname im png Format 
       in das aktuelle Verzeichnis
       Es wird vorausgesetzt, dass der Dateiname kein Verzeichnis
       beinhaltet.
    */ 
    public static void writeImage(BufferedImage img, String filename){
	String dir = System.getProperty("user.dir");
	try {
	    File file = new File(dir,filename);
	    ImageIO.write(img,"png",file);
	} catch (IOException | IllegalArgumentException e){
	    System.out.println("Could not write image " + filename);
	}
    }

    /* Liest ein Bild aus der Datei mit dem Namen filename
     Abbruch, wenn die Datei nicht gefunden bzw. gelesen werden kann.
     Das eingelesene Bild wird am Ende zurückgegeben
    */
    public static BufferedImage readImage(String filename){
	BufferedImage img = null;
	File file;
	try {
	    file = new File(filename);
	    img = ImageIO.read(file);
	} catch (IOException e){
	    System.out.println("Could not read " + filename);
	    System.exit(0);
	}
	return img;
    }

    private static int[][] getImageData(BufferedImage img) {
        int w = img.getWidth();
	int h = img.getHeight();

	int[][] data = new int[h][w];
	for (int i=0;i<h;i++){  
	    for (int j=0;j<w;j++){
                img.getRGB(j,i);
            }
        }
        return data;
    }

    public static int[][] getImageData(String filename){
        BufferedImage img = readImage(filename);
        if (img != null) {
            return getImageData(img);
        } else {
            return null;
        }
    }

}
    
