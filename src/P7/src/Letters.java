package P7.src;

// Michelle Pohl
public class Letters {

    // Aufgabenteil (a)

    // Methode zur Überprüfung, ob ein Zeichen in einem String enthalten ist
    public static boolean contains(String text, char ch) {
        return text.indexOf(ch) >= 0;
    }

    // Überladene Methode zur Überprüfung, ob ein Zeichen in einem StringBuffer enthalten ist
    public static boolean contains(StringBuffer buffer, char ch) {
        return buffer.indexOf(String.valueOf(ch)) >= 0;
    }

    // Aufgabenteil (b)
    public static void addLetter(StringBuffer sBuf, char c) {

        int position = 0;

        // Suche nach der Position
        while (position < sBuf.length() && sBuf.charAt(position) < c) {
            position++;
        }

        // Füge  Zeichen ein
        sBuf.insert(position, c);

    }

    // Aufgabenteil (c)
    public static void checkSharedLetters(String w1, String w2) {
        StringBuffer sharedLetters = new StringBuffer();
        StringBuffer uniqueLettersW1 = new StringBuffer();
        StringBuffer uniqueLettersW2 = new StringBuffer();

        // Prüfe jedes Zeichen im ersten Wort
        for (int i = 0; i < w1.length(); i++) {
            char c = w1.charAt(i);

            if (contains(w2, c) && !contains(sharedLetters, c)) {
                addLetter(sharedLetters, c);
            }
            else if (!contains(w2, c) && !contains(uniqueLettersW1, c)) {
                addLetter(uniqueLettersW1, c);
            }
        }

        for (int i = 0; i < w2.length(); i++) {
            char c = w2.charAt(i);

            if (!contains(w1, c) && !contains(uniqueLettersW2, c)) {
                addLetter(uniqueLettersW2, c);
            }
        }

        System.out.println("Word 1: " + w1);
        System.out.println("Word 2: " + w2);
        System.out.println("Shared letters: " + sharedLetters);            // Ausgabe ergänzen!
        System.out.println("Unique letters of word 1: " + uniqueLettersW1);  // Ausgabe ergänzen!
        System.out.println("Unique letters of word 2: " + uniqueLettersW2);  // Ausgabe ergänzen!
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            // Aufgabenteil (d): Aufruf von checkSharedLetters ergänzen
            String word1 = args[0].toLowerCase();
            String word2 = args[1].toLowerCase();
            checkSharedLetters(word1, word2);
        } else {
            System.out.println("Call: \njavaSharedLetters <word1> <word2>");
        }
    }
}
