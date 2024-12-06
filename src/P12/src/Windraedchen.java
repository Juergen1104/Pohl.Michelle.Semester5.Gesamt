package P12.src;// Michelle Pohl

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;


public class Windraedchen {
    private static int[][] coords = {{200,0},{200,200},{250,50}};
    private static int n = 9;
    private static Shape[] shapes = new Shape[n];
    private static Area composite;
    
    static {
        // Basisform anlegen
        Polygon p = new Polygon();

        for (int[]xy : coords){
            p.addPoint(xy[0], xy[1]);
        }
        int k = 9;
        // 9 Rotationen
        for (int i=1;i<=k;i++){
            // Rotation um 40,80,120, … , 360 Grad
            // Rotation um den Punkt (200,200)
            //at.rotate((Math.PI / k) * i * 2,200,200);
            AffineTransform at = AffineTransform.getRotateInstance((Math.PI / k) * i * 2,200,200);
            shapes[i-1] = at.createTransformedShape(p);       
        }

        composite = new Area(shapes[0]);
        for (int i=1;i<shapes.length;i++) {
            composite.add(new Area(shapes[i]));
        }
    }

    public static Shape getShape() {
        return composite;
    }

    

    
}
    

