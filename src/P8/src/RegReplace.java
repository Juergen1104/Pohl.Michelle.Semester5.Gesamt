package P8.src;

// Michelle Pohl
public class RegReplace {

    /* *** Aufgabenteil (a) *** */
    // 2
    public static String swapChars(String text, char a, char b) {

    // Hilfszeichen für den temporären Austausch (Nullzeichen als Platzhalter)
        String temp = Character.toString('\0');

        // Ersetze alle 'a' durch das Nullzeichen (temp)
        text = text.replaceAll(Character.toString(a), temp);

        // Ersetze alle 'b' durch 'a'
        text = text.replaceAll(Character.toString(b), Character.toString(a));

        // Ersetze alle Nullzeichen (temp) durch 'b'
        text = text.replaceAll(temp, Character.toString(b));

        return text;

    }

    /* *** Aufgabenteil (b) *** */
    // 2
    public static String changeNameOrder(String name) {

        // Regex: erster Teil matcht alle Vornamen inkl. Leerzeichen, letzter Namensteil ist der Nachname
        return name.replaceAll("(.+?)\\s+([A-Za-zäöüÄÖÜß-]+)$", "$2, $1");

    }

    /* *** Aufgabenteil (c) *** */
    // 2
    public static String replaceUmlaute(String text) {
        String[][] uMap = {{"ä", "ae"}, {"ö", "oe"}, {"ü", "ue"}};

        for (String[] umlaut : uMap) {
            text = text.replaceAll(umlaut[0], umlaut[1]);

            String upperUmlaut = Character.toUpperCase(umlaut[0].charAt(0)) + umlaut[0].substring(1);
            String upperReplacement = Character.toUpperCase(umlaut[1].charAt(0)) + umlaut[1].substring(1);
            text = text.replaceAll(upperUmlaut, upperReplacement);
        }


        return text;

    }

    /* *************  Testaufrufe ************** */

    public static void main(String[] args) {
        /* Test Aufgabenteil (a) */
        System.out.println("Test (a)):\n");

        String s1 = "aabbccc";
        System.out.print(s1 + " --> ");
        System.out.println(swapChars(s1, 'a', 'b'));

        String s2 = "128 895 556 788 999";
        System.out.print(s2 + " --> ");
        System.out.println(swapChars(s2, '8', '9'));


        /* Test Aufgabenteil (b) */
        System.out.println("\nTest (b)):\n");

        String[] sArr1 = {"Tina Meyer", "Thomas  Müller", "Marie-Agnes Strack-Zimmermann",
                "Rüdiger Ägidius Öhmig ",
                "Franz-Ferdinand Maximilian Alexander vOstwestfalen-Lippe"};

        for (String s : sArr1) {
            System.out.println(s + " -> " + changeNameOrder(s));
        }

        /* Test Aufgabenteil (c) */
        System.out.println("\nTest (c)):\n");

        String[] sArr2 = {sArr1[1], sArr1[3]};
        for (String s : sArr2) {
            System.out.println(s + " -> " + replaceUmlaute(s));
        }
    }

}
