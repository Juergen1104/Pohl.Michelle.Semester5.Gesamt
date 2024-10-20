package P6.src;

public class DynStack extends DynSequence {

    // b) Methode push
    public void push(double value) {
        // Füge das neue Element am Ende der Sequenz hinzu
        insertValueAt(value, size());
    }

    // b) Methode pop
    public double pop() {
        // Entferne und gib das letzte Element der Sequenz zurück
        if (!isEmpty()) {
            return removeValueAt(size() - 1);
        }
        return Double.NaN; // Wenn der Stack leer ist
    }

    public static void main(String[] args) {
        DynStack stack = new DynStack();

        // Fülle den Stack mit 5 Zufallswerten zwischen 0 und 99
        for (int i = 0; i < 5; i++) {
            int randomValue = (int) (Math.random() * 100);
            stack.push(randomValue);
            System.out.println(stack);
        }

        double sum = 0;
        // Entferne alle Elemente aus dem Stack und gib sie aus
        while (!stack.isEmpty()) {
            double removedValue = stack.pop();
            System.out.println(stack);
            sum += removedValue;
        }

        // Gib die Summe der entfernten Werte aus
        System.out.println("Summe: " + sum);
    }
}
