package P6.src;

//public class DynSequence {
//    private double[] array;
//
//    public DynSequence() {
//        array = new double[0];
//    }
//
//    public int size() {
//        return array.length;
//    }
//
//    // a) Methode isEmpty
//    public boolean isEmpty() {
//        return array.length == 0;
//    }
//
//    // a) Methode insertValueAt
//    public void insertValueAt(double value, int index) {
//        // Überprüfen des Indexwerts
//        if (index < 0) {
//            index = 0;
//        } else if (index > array.length) {
//            index = array.length;
//        }
//
//        // Neues Feld erstellen, das um ein Element länger ist
//        double[] newArray = new double[array.length + 1];
//
//        // Bisherige Werte kopieren und den neuen Wert einfügen
//        for (int i = 0, j = 0; i < newArray.length; i++) {
//            if (i == index) {
//                newArray[i] = value;
//            } else {
//                newArray[i] = array[j++];
//            }
//        }
//
//        // Altes Feld durch das neue ersetzen
//        array = newArray;
//    }
//
//    // a) Methode removeValueAt
//    public double removeValueAt(int index) {
//        if (index < 0 || index >= array.length) {
//            return Double.NaN; // Ungültiger Index
//        }
//
//        // Den Wert an der gegebenen Position speichern
//        double removedValue = array[index];
//
//        // Neues Feld erstellen, das um ein Element kleiner ist
//        double[] newArray = new double[array.length - 1];
//
//        // Elemente kopieren und das zu löschende Element auslassen
//        for (int i = 0, j = 0; i < array.length; i++) {
//            if (i != index) {
//                newArray[j++] = array[i];
//            }
//        }
//
//        // Altes Feld durch das neue ersetzen
//        array = newArray;
//
//        return removedValue;
//    }
//
//    // a) Methode toString
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Inhalt:");
//        for (double value : array) {
//            sb.append(" ").append(value);
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        // Test für die DynSequence Klasse
//        DynSequence sequence = new DynSequence();
//
//        // Einfügen von Werten
//        sequence.insertValueAt(1.5, 0);
//        sequence.insertValueAt(2.5, 1);
//        sequence.insertValueAt(3.5, 2);
//        sequence.insertValueAt(4.5, 3);
//        sequence.insertValueAt(5.5, 4);
//        System.out.println(sequence);
//
//        // Entfernen von Werten
//        sequence.removeValueAt(3);
//        System.out.println(sequence);
//        sequence.removeValueAt(2);
//        System.out.println(sequence);
//        sequence.removeValueAt(1);
//        System.out.println(sequence);
//    }
//}
public class DynSequence {
    private double[] array;

    public DynSequence() {
        array = new double[0];
    }

    public int size() {
        return array.length;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public void insertValueAt(double value, int index) {
        if (index < 0) {
            index = 0;
        } else if (index > array.length) {
            index = array.length;
        }

        double[] newArray = new double[array.length + 1];
        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[j++];
            }
        }
        array = newArray;
    }

    public double removeValueAt(int index) {
        if (index < 0 || index >= array.length) {
            return Double.NaN;
        }

        double removedValue = array[index];
        double[] newArray = new double[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        array = newArray;
        return removedValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Inhalt:");
        for (double value : array) {
            sb.append(" ").append(value);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DynSequence sequence = new DynSequence();

        // Einfügen der Werte {0.5, 1.5, 2.5, ..., 9.5} am Anfang
        for (double i = 0.5; i <= 9.5; i += 1.0) {
            sequence.insertValueAt(i, 0);  // Einfügen am Anfang
        }

        // Ausgabe der Sequenz
        System.out.println(sequence);

        // Löschen des zweitletzten Elements
        sequence.removeValueAt(sequence.size() - 2);
        System.out.println(sequence);

        // Löschen des drittletzten Elements
        sequence.removeValueAt(sequence.size() - 3);
        System.out.println(sequence);

        // Löschen des viertletzten Elements
        sequence.removeValueAt(sequence.size() - 4);
        System.out.println(sequence);
    }
}

