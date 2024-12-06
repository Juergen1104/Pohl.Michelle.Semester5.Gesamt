package P12.src;// Michelle Pohl
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapeAnimFrame extends JFrame {
    private AnimCanvas aCanvas;
    private int w = 1000, h = 800;
    private long count = 0;

    public ShapeAnimFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        createComponents();
        this.setSize(w,h);
        this.setLocation(100, 50);
        this.createShapes();
        this.aCanvas.startAnimation();
        this.setResizable(false);
    }

    private void createComponents() {
        Container c = this.getContentPane();
        this.aCanvas = new AnimCanvas();     // Zeichenfläche generieren
        c.add(this.aCanvas);
    }

    // Shape-Sequenzen (Felder mit Shape-Objekten) generieren und der
    // Zeichenfäche hinzufügen
    private void createShapes() {
        ShapeSequenceCreator ssc = new ShapeSequenceCreator(w,h, aCanvas);
    }

    public static void main(String[] args) {
        ShapeAnimFrame gui = new ShapeAnimFrame();
        gui.setVisible(true);
    }

    /* *** Klasse, in der die Sequenzen nacheinander angezeigt / gezeichnet werden *** */
    public class AnimCanvas extends Canvas implements Runnable {
        private ArrayList<ColoredShape[]> shapeSequences = new ArrayList<>();
        private Thread t;
        private int indx = 0;
        private boolean isRunning = true;

        // Shape-Sequenz hinzufügen
        public synchronized void addShapeSequence(ColoredShape[] shapes) {
            shapeSequences.add(shapes);
        }

        // Canvas als Thread starten (alle 20ms neu zeichnen)
        public void startAnimation() {
            this.t = new Thread(this);
            this.t.start();
        }

        // alle 20ms das nächste Bild aus jeder Sequenz zeichnen
        public void run() {
            while (isRunning) {
                try {
                    t.sleep(20);
                    this.repaint();
                    indx = (indx + 1) % 1000;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.black);
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            // Shape am Index i von allen Shape-Sequenzen zeichnen
            for (ColoredShape[] shapes : shapeSequences) {
                shapes[indx%shapes.length].paint(g);
            }
            // Window System zum Update des Fensters zwingen 
            Toolkit.getDefaultToolkit().sync();
        }
    }
}
