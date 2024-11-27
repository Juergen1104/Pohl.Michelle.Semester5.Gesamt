package P11.src;// Michelle Pohl

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OscarGUI extends JFrame{
    private static Nominee[] nominees = Nominee.getNominees();

    private JComboBox<Integer> years = new JComboBox<>();     // Combobox für Jahre
    private JComboBox<String> categories = new JComboBox<>(); // Combobox für Kategorien
    private JCheckBox winnersOnly;
    private JTextArea results;

    private static Color bgc1 = new Color(255, 204, 102);
    private static Color bgc2 = new Color(255, 255, 240);

    public OscarGUI(){
	super ("Academy Awards GUI");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.createComponents();
        this.createListener();
	this.pack();
    }

    /* *** Aufgabe 2a *** */
    // 2
    private void updateText() {

        // Werte aus den UI-Komponenten lesen
        int selectedYear = (int) this.years.getSelectedItem();
        String selectedCategory = (String) this.categories.getSelectedItem();
        boolean onlyWinners = this.winnersOnly.isSelected();

        // FilterUtils aufrufen
        Nominee[] filteredNominees = FilterUtils.getNomineesInYear(nominees, selectedYear, selectedCategory, onlyWinners);

        // Ergebnisse in den Textbereich schreiben
        this.results.setText(createText(filteredNominees));

    }

    /* *** Aufgabe 2b *** */

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateText();
        }
    }

    /* *** Aufgabe 2c *** */
    //
    private void createListener() {

        ActionListener listener = new ComboBoxListener();

        this.years.addActionListener(listener);
        this.categories.addActionListener(listener);
        this.winnersOnly.addActionListener(listener);
    }


    /* ************************************ */
    /* ***   ab hier nichts mehr ändern *** */
    /* ************************************ */

    public void createComponents() {
        JPanel p1 = createControlPanel();
        createCombinedBorder(p1);

        JPanel p2 = createTextPanel();
        createCombinedBorder(p2);

        Container c = this.getContentPane();
        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
    }

    /* create Panel with controls to selevt year, category and whether
       all Nominees are shown or only Winners */
    private JPanel createControlPanel(){
        JPanel p = new JPanel();

        // Combobox years füllen
        for (int y = 1928; y <= 2024; y++) {
            this.years.addItem(y);
        }
        this.years.setSelectedItem(2024);

        // Combobox categories füllen
        this.categories.addItem("ALL");
        for (String cat : Nominee.CATEGORIES) {
            this.categories.addItem(cat);
        }
        this.categories.setSelectedIndex(0);

        // Checkbox anlegen
        this.winnersOnly = new JCheckBox();
        this.winnersOnly.setBackground(bgc1);

        // Labels anlegen
        JLabel l1 = new JLabel("Year: ", SwingConstants.RIGHT);
        JLabel l2 = new JLabel("Category: ", SwingConstants.RIGHT);
        JLabel l3 = new JLabel("Show Winners Only: ", SwingConstants.RIGHT);


        // Layout
        p.setLayout(new GridLayout(3,2,20,5));

        for (Component c : new Component[] {l1, this.years, l2,
                                            this.categories, l3,
                                            this.winnersOnly}){
            p.add(c);
        }

        // ***
        JPanel p2 = new JPanel();
        p2.setBackground(bgc1);
        p.setPreferredSize(new Dimension(350,100));
        p.setOpaque(false);
        p2.add(p);
        return p2;
    }

    /* create and initialize Panel with JTextArea showing
       results of filter operations */
    private JPanel createTextPanel() {
        JPanel p = new JPanel();
        this.results = new JTextArea(15,40);
        JScrollPane scroller = new JScrollPane(this.results);
        createCombinedBorder(this.results);

        // Nominee[] nmArr = FilterUtils.getNomineesInYear(nominees, 2024, "ALL", true);
        // this.results.setText(createText(nmArr));
        this.updateText();
        this.results.setBackground(bgc2);

        p.add(scroller);
        p.setBackground(bgc1);
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

    /* Methode rzeugt einen zweiteiligen Rahmen für eine Komponente.
       Die Komponente wird durch einen leeren Rahmen (5 Pixel Plat nach oben und
       unten, 10 nach links und rechts) umgeben und dieser wiederum durch eine
       schwarze Linie.
     */
    private static void createCombinedBorder(JComponent c) {
        c.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                                                       BorderFactory.createEmptyBorder(5,10,5,10)));
    }


    public static void main(String[] args) {
	OscarGUI gui = new OscarGUI();
	gui.setVisible(true);
    }

}
