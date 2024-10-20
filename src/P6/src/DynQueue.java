package P6.src;

public class DynQueue extends DynSequence {

    // c) Methode enqueue: Fügt ein Element am Ende der Queue hinzu
    public void enqueue(double value) {
        insertValueAt(value, size());
    }

    // c) Methode dequeue: Entfernt das Element am Anfang der Queue und gibt es zurück
    public double dequeue() {
        if (!isEmpty()) {
            return removeValueAt(0);
        }
        return Double.NaN; // Wenn die Queue leer ist
    }

    public static void main(String[] args) {
        DynQueue queue = new DynQueue();

        // Fülle die Queue mit 5 Zufallswerten zwischen 0 und 99
        for (int i = 0; i < 5; i++) {
            int randomValue = (int) (Math.random() * 100);
            queue.enqueue(randomValue);
            System.out.println(queue);
        }

        double sum = 0;
        // Entferne alle Elemente aus der Queue und gib sie aus
        while (!queue.isEmpty()) {
            double removedValue = queue.dequeue();
            System.out.println(queue);
            sum += removedValue;
        }

        // Gib die Summe der entfernten Werte aus
        System.out.println("Summe: " + sum);
    }
}
