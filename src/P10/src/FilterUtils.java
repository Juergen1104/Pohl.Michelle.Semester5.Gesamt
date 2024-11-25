package P10.src;

import java.util.ArrayList;

public class FilterUtils {

    /*
      Die Methode filtert alle Nominierungen aus dem Feld nArr aus, die
      in einem bestimmten Jahr und für eine bestimmte Kategorie erfolgt
      sind. Dabei steht der Wert "ALL" für alle Kategorien.
      Ist der Wert des Parameters winnerOnly true, dann werden nur 
      Gewinner ermittelt, ansonsten alle Nominierungen.   
      Die ausgefilterten Objekte werden in einem Feld zurückgegeben.
     */
    public static Nominee[] getNomineesInYear(Nominee[] nArr, int y,
                                              String category,
                                              boolean winnerOnly) {
        ArrayList<Nominee> nomList = new ArrayList<>();
        for (Nominee nom : nArr) {
            if (nom.getYear() == y) {
                if (category.equals("ALL") || category.equals(nom.getCategory())) {
                    if (!winnerOnly || nom.hasWon()) {
                        nomList.add(nom);
                    }
                }
            }
        }

        return nomList.toArray(new Nominee[nomList.size()]);
    }
}
