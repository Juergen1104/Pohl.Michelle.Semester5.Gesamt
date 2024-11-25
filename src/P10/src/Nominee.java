package P10.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Nominee {
    public final static String[] CATEGORIES = {"ACTOR", "ACTRESS", "DIRECTING",
                                                "ACTOR IN A LEADING ROLE",
                                                "ACTRESS IN A LEADING ROLE",
                                                "ACTOR IN A SUPPORTING ROLE",
                                                "ACTRESS IN A SUPPORTING ROLE"};
    
    private int year;         // Jahr der Oscar-Zeremonie
    private String category;  // Kategorie
    private String name;      // Name des/der Nominierten
    private String film;      // Film
    private boolean hasWon;   // hat der/diejenige gewonnen?

    public Nominee(int year, String category, String name,
                   String film, boolean hasWon) {
        this.year = year;
        this.category = category;
        this.name = name;
        this.film = film;
        this.hasWon = hasWon;
    }

    public int getYear() {
        return this.year;
    }

    public String getCategory() {
        return this.category;
    }

    public boolean hasWon() {
        return this.hasWon;
    }

    @Override
    public String toString() {
        return "Category: " + this.category + ":\n     " + this.name + " (" + this.year + ", " + this.film + ")\n";
    }

    /* method reads the data from the file "academyAwards.csv", 
       creates a Nominee instance from each line in the file and 
       returns an array containing all instances.
     */
    public static Nominee[] getNominees() {
        String filenname = "academyAwards.csv";
        java.util.ArrayList<Nominee> nomList = new java.util.ArrayList<>();
        try (BufferedReader bufR = new BufferedReader(new FileReader(filenname))) {
            String line;
            while ((line = bufR.readLine()) != null){
                String[] tokens = line.split(",");
                Nominee nm = new Nominee(Integer.parseInt(tokens[0]),
                                         tokens[1],tokens[2],tokens[3],
                                         tokens[4].equals("True") ? true : false);
                nomList.add(nm);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
        return nomList.toArray(new Nominee[nomList.size()]);
    }

    public static void main(String[] args) {
        Nominee[]  nArr = Nominee.getNominees();
        System.out.println(nArr[0]);
    }
}
