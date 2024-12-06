package P12.src;// Michelle Pohl

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Schneemann {
    private static Shape composite;

    static {
        Ellipse2D.Double base = new Ellipse2D.Double(20, 80, 100, 100); // Unterer Kreis
        Ellipse2D.Double middle = new Ellipse2D.Double(35, 40, 70, 70); // Mittlerer Kreis
        Ellipse2D.Double head = new Ellipse2D.Double(50, 10, 40, 40); // Kopf

        Ellipse2D.Double eyeLeft = new Ellipse2D.Double(60, 20, 5, 5); // Linkes Auge
        Ellipse2D.Double eyeRight = new Ellipse2D.Double(75, 20, 5, 5); // Rechtes Auge
        Ellipse2D.Double button1 = new Ellipse2D.Double(65, 50, 5, 5); // Oberer Knopf
        Ellipse2D.Double button2 = new Ellipse2D.Double(65, 65, 5, 5); // Mittlerer Knopf
        Ellipse2D.Double button3 = new Ellipse2D.Double(65, 80, 5, 5); // Unterer Knopf

        Polygon nose = new Polygon();
        nose.addPoint(70, 30);
        nose.addPoint(70, 35);
        nose.addPoint(90, 32);

        Arc2D.Double mouth = new Arc2D.Double(58, 28, 25, 15, 200, 140, Arc2D.OPEN);

        Area schneemann = new Area(base);
        schneemann.add(new Area(middle));
        schneemann.add(new Area(head));
        schneemann.add(new Area(eyeLeft));
        schneemann.add(new Area(eyeRight));
        schneemann.add(new Area(button1));
        schneemann.add(new Area(button2));
        schneemann.add(new Area(button3));
        schneemann.add(new Area(nose));
        schneemann.add(new Area(mouth));

        composite = schneemann;
    }

    public static Shape getShape() {
        return composite;
    }
}
