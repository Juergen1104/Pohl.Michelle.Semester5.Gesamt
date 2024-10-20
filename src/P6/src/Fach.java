package P6.src;

public class Fach {
    private String name;
    private float note;

    public Fach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    private String umwandeln(float note) {
        int gerundet = Math.round(note);
        switch (gerundet) {
            case 1:
                return "sehr gut";
            case 2:
                return "gut";
            case 3:
                return "befriedigend";
            case 4:
                return "ausreichend";
            case 5:
                return "mangelhaft";
            case 6:
                return "ungenuegend";
            default:
                return "--";
        }
    }

    private String toString(int zeilenLaenge) {
        String formatted = String.format("%-" + zeilenLaenge + "s %s", name, umwandeln(note));
        return formatted;
    }

    public String toString() {
        return toString(50);
    }
}
