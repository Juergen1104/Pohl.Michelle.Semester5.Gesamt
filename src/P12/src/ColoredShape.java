package P12.src;// Michelle Pohl

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ColoredShape {
    private Shape shape;               // Form
    private Color cInner, cBoundary;   // Füllfarbe und Farbe für den Rand der Figur
    private BasicStroke stroke;        // Strich für die Unrandung (hier nur Breite einstellbar)


    /* ************************************* */
    /* ***          Aufgabe 1a           *** */
    /* ************************************* */

    /* Verschiebung um dx horizontal und dy vertikal */
    // 1P
    public void translate(double dx, double dy) {
        AffineTransform at = AffineTransform.getTranslateInstance(dx, dy);
        this.shape = at.createTransformedShape(this.shape);
    }

    /* Rotation um den Punkt p und um den Winkel theta 
       theta muss im Bogenmaß angegeben werden
     */
    // 1P
    public void rotate(double theta, Point p) {
        AffineTransform at = AffineTransform.getRotateInstance(theta, p.x, p.y);
        this.shape = at.createTransformedShape(this.shape);
    }

    /* Rotation um den Punkt p und um den Winkel theta 
       um das Zentrum der Form 
       theta muss im Bogenmaß angegeben werden
     */
    public void rotate(double theta) {
        Point p = getCenter();
        rotate(theta, p);
    }

    /* Skalierung der Form um den Faktor sx in x-Richtung und sy in y-Richtung 
       Die Skalierung erfolgt so, dass die Zentren der Shapes übereinander liegen
       Hierzu wird eine entsprechende Verschiebung vorgenommen.
     */
    // 2P
    public void scale(double sx, double sy) {
        Point centerBefore = getCenter();

        // Skalierung durchführen
        AffineTransform at = AffineTransform.getScaleInstance(sx, sy);
        this.shape = at.createTransformedShape(this.shape);

        // Neues Zentrum berechnen
        Point centerAfter = getCenter();

        // Verschiebung berechnen
        double dx = centerBefore.x - centerAfter.x;
        double dy = centerBefore.y - centerAfter.y;

        // Form zurückverschieben, sodass die Zentren übereinstimmen
        translate(dx, dy);
    }


    /* zeichnet die Form:
       1. Füllung zeichnen
       2. Umrandung mit dem gesetzten Stroke zeichnen 
       Wenn die Farben für das Innere / Äußere den Wert null haben,
       wird der zugehörige Teil nicht gezeichnet
    */
    // 2P
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Füllung zeichnen
        if (cInner != null) {
            g2.setColor(cInner);
            g2.fill(this.shape);
        }

        // Rand zeichnen
        if (cBoundary != null) {
            g2.setColor(cBoundary);
            g2.setStroke(this.stroke);
            g2.draw(this.shape);
        }

    }

    /* ************************************************************** */
    /*                   ab hier nichts mehr ändern                   */
    /* ************************************************************** */

    /* Konstruktor */
    public ColoredShape(Shape shape, Color color1, Color color2, Float f) {
        this.shape = shape;
        this.cInner = color1;
        this.cBoundary = color2;
        if (stroke != null) {
            this.stroke = new BasicStroke(f.floatValue());
        } else {
            this.stroke = new BasicStroke(1.0f);
        }
    }

    /* Kopierkonstruktor 
       Eine neue Shape-Instanz wird durch die Anwendung einer Einheitstransformation
       durchgeführt.
    */
    public ColoredShape(ColoredShape cShape) {
        this(new AffineTransform().createTransformedShape(cShape.shape),
                cShape.cInner, cShape.cBoundary, cShape.stroke.getLineWidth());
    }

    /* bestimmt das Zentrum der Form durch den Mittelpunkt der Bounding Box
       und gibt dieses als Punkt zurück
    */
    private Point getCenter() {
        Rectangle r = this.shape.getBounds();
        int cx = (int) (r.getX() + r.getWidth() / 2);
        int cy = (int) (r.getY() + r.getHeight() / 2);
        return new Point(cx, cy);
    }

}
