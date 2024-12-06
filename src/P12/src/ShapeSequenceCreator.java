package P12.src;// Michelle Pohl
import java.awt.*;

public class ShapeSequenceCreator {
    private ShapeAnimFrame.AnimCanvas aCanv;
    private int w, h;

    public ShapeSequenceCreator(int w, int h, ShapeAnimFrame.AnimCanvas aCanv) {
        this.aCanv = aCanv;
        this.w = w;
        this.h = h;

        /* *** rotierendes Windraedchen *** */

        // ColoredShape cShape1 = createShape_1();
        //  ColoredShape[] shapeArr1 = createSequence_1(cShape1);
        // aCanv.addShapeSequence(shapeArr1);


        /* für Aufgabe 1c den folgenden Blockkommentar entfernen */

        ColoredShape cShape2 = createShape_2();
        ColoredShape[] shapeArr2 = createSequence_2(cShape2);
        aCanv.addShapeSequence(shapeArr2);
    }

    /* *** Aufgabe 1c *** */


    public ColoredShape createShape_2() {
        // Schneemann-Shape laden
        Shape shape = Schneemann.getShape();
        ColoredShape cShape = new ColoredShape(shape, Color.WHITE, Color.BLACK, 2.0f);

        cShape.scale(0.8, 0.8);
        cShape.translate(10, 100);
        return cShape;
    }

    public ColoredShape[] createSequence_2(ColoredShape shape) {
        int length = 100;
        ColoredShape[] shapeArr = new ColoredShape[length];
        shapeArr[0] = shape;

        double amplitude = 75;
        double frequency = 2 * Math.PI / length;

        for (int i = 1; i < length; i++) {
            shapeArr[i] = new ColoredShape(shapeArr[0]);
            double dx = amplitude * Math.sin(frequency * i);
            shapeArr[i].translate(dx, 0);
        }
        return shapeArr;
    }

    /* *** Beispielcode (Rotation) *** */

    public ColoredShape createShape_1() {
        Shape shape = Windraedchen.getShape();
        double sw = shape.getBounds().getWidth();
        double sh = shape.getBounds().getHeight();
        ColoredShape cShape = new ColoredShape(shape, Color.BLUE, Color.ORANGE, 3.0f);
        cShape.translate((w - sw) / 2, (h - sh) / 2);
        return cShape;
    }

    public ColoredShape[] createSequence_1(ColoredShape shape) {
        ColoredShape[] shapeArr = new ColoredShape[200];
        shapeArr[0] = shape;

        double dTheta = 2.0 * Math.PI / shapeArr.length;
        for (int i = 1; i < shapeArr.length; i++) {
            shapeArr[i] = new ColoredShape(shapeArr[0]);
            shapeArr[i].rotate(i * dTheta);
        }
        return shapeArr;
    }
}
