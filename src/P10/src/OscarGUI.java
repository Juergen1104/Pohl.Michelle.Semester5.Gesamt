package P10.src;// Michelle Pohl
import javax.swing.*;
import java.awt.*;

public class OscarGUI extends JFrame {
    private static final Color CONTROL_PANEL_COLOR = new Color(255, 165, 0);
    private static final Color TEXT_PANEL_COLOR = new Color(255, 250, 205);
    private static Nominee[] nominees = Nominee.getNominees();
    // (a) + (b) weitere Instanzvariableb
    private JComboBox<Integer> years = new JComboBox<>();
    private JComboBox<String> categories = new JComboBox<>();
    private JCheckBox winnerOnlyCheckBox;
    private JTextArea textArea;

    public OscarGUI() {
        super("Academy Awards GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.createComponents();
        this.pack();
    }

    /* Methode erzeugt einen zweiteiligen Rahmen für eine Komponente.
       Die Komponente wird durch einen leeren Rahmen (5 Pixel Plat nach oben und
       unten, 10 nach links und rechts) umgeben und dieser wiederum durch eine
       schwarze Linie.
     */
    private static void createCombinedBorder(JComponent c) {
        c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

    public static void main(String[] args) {
        OscarGUI gui = new OscarGUI();
        gui.setVisible(true);
    }

    public void createComponents() {
        JPanel p1 = createControlPanel();
        createCombinedBorder(p1);

        JPanel p2 = createTextPanel();
        createCombinedBorder(p2);

        Container c = this.getContentPane();
        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
    }

    /* *** Aufgabe 2a *** */
    // 4
    private JPanel createControlPanel() {
        JPanel p = new JPanel();

        p.setLayout(new GridLayout(3, 2, 20, 5));
        p.setBackground(CONTROL_PANEL_COLOR);

        // Jahre zur Combobox hinzufügen
        for (int year = 1927; year <= 2024; year++) {
            years.addItem(year);
        }
        years.setSelectedItem(1927);

        // Kategorien zur Combobox hinzufügen
        categories.addItem("ALL");
        for (String category : Nominee.CATEGORIES) {
            categories.addItem(category);
        }
        categories.setSelectedItem("ALL");

        winnerOnlyCheckBox = new JCheckBox();
        winnerOnlyCheckBox.setSelected(false);

        // Labels erstellen
        JLabel yearLabel = new JLabel("Year:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel winnerOnlyLabel = new JLabel("Show Winners Only:");
        yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        categoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        winnerOnlyLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        p.add(yearLabel);
        p.add(years);
        p.add(categoryLabel);
        p.add(categories);
        p.add(winnerOnlyLabel);
        p.add(winnerOnlyCheckBox);


        return p;
    }

    /* *** Aufgabe 2b *** */
    // 2
    private JPanel createTextPanel() {
        Nominee[] nmArr = FilterUtils.getNomineesInYear(nominees, 2024, "ALL", true);

        textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
        textArea.setBackground(TEXT_PANEL_COLOR);

        // Rahmen setzen
        createCombinedBorder(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setText(createText(nmArr));

        JPanel p = new JPanel();
        p.setBackground(TEXT_PANEL_COLOR);
        p.setBackground(CONTROL_PANEL_COLOR);
        p.add(scrollPane);

        return p;
    }

    /* erzeugt einen Text aus den String-Repräsentationen der Elemente
       in dem Feld nmArr
    */
    private String createText(Nominee[] nmArr) {
        StringBuffer sBuf = new StringBuffer();
        for (Nominee nm : nmArr) {
            sBuf.append(nm + "\n");
        }
        return sBuf.toString();
    }

}
