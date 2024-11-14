package P9.src;

public class Bruch implements java.lang.Number {
    private int zaehler, nenner;

    public Bruch(int z, int n) {
        this.zaehler = z;
        this.nenner = n;
    }

    public String toString() {
        return "(" + this.zaehler + "/" + this.nenner + ")";
    }

    /* Aufgabenteil (c) */
    @Override
    public double toDouble() {
        return (double) zaehler / nenner;
    }

    @Override
    public boolean equals(java.lang.Number n2) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof java.lang.Number)) return false;
        java.lang.Number other = (java.lang.Number) obj;
        return Double.compare(this.toDouble(), other.toDouble()) == 0;
    }

    @Override
    public int compareTo(java.lang.Number other) {
        return Double.compare(this.toDouble(), other.toDouble());
    }
}
