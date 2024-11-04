package P8.src;

// Michelle Pohl
public class RegEx {

    /* positive ganze Zahl ohne führende Nullen mit einer ungeraden 
       Anzahl von Ziffern? */
    // 1
    public static boolean check1(String s) {
        //	return s.matches("[1-9]\\d{0,2}([0-9]{2})*");
        //    return s.matches("[1-9]\\d{0,2}(\\d{2})*");
        return s.matches("[1-9](\\d{2})*");
    }

    /*  Primzahl < 20 */
    // 1
    public static boolean check2(String s) {
        return s.matches("2|3|5|7|11|13|17|19");
    }

    /* Ziffernfolge, die mindestens eine 7 enthält */
    // 1
    public static boolean check3(String s) {
        return s.matches("\\d*7\\d*");
    }

    /* Ziffernfolge, die maximal 2 Mal ein x oder X enthält */
    // 2
    public static boolean check4(String s) {
        return s.matches("[^Xx]*(X|x)?[^Xx]*(X|x)?[^Xx]*");
    }

    /* Ziffernfolge, deren erste und letzte Ziffer identisch ist
       und ungerade und die dazwischen identische, gerade Ziffern enthält */
    // 2
    public static boolean check5(String s) {
        return s.matches("[13579](0|2|4|6|8)+[13579]");
    }

    /* (pos. pder neg.) Gleitkommazahl mit mindestens einer
       Vor- und einer Nachkommastelle und ohne führende sowie
       ohne zusätzliche Nullen am Ende, aber mindestens eine Ziffer
       vor und nach dem Komma
    */
    // 3
    public static boolean check6(String s) {
        //return s.matches("[-+]?(0|[1-9]\\d*)\\.\\d*[1-9]");
        //return s.matches("[-+]?(0|[1-9]\\d*)\\.\\d+");
        //return s.matches("[-+]?(0|[1-9]\\d*)\\.\\d*[1-9]");
        // Nachkommanull wird noch zugelassen......
        return s.matches("[-+]?(0|[1-9]\\d*)\\.\\d+([1-9])?");
    }


    /* *************  Testaufrufe ************** */

    public static void main(String[] args) {
        System.out.println("Test 1:");
        String[] str1 = {"1", "123", "135", "999999999", "0", "13",};
        for (String s : str1) {
            System.out.println("\"" + s + "\"" + " -> " + check1(s));
        }

        System.out.println("\nTest 2:");
        String[] str2 = {"2", "19", "9", "21"};
        for (String s : str2) {
            System.out.println("\"" + s + "\"" + " -> " + check2(s));
        }

        System.out.println("\nTest 3:");
        String[] str3 = {"0123456789", "7", "117", "012345689"};
        for (String s : str3) {
            System.out.println("\"" + s + "\"" + " -> " + check3(s));
        }

        System.out.println("\nTest 4:");
        String[] str4 = {"aXb", "Xx", "XaABbX", "abc", "xaxax", "xXx"};
        for (String s : str4) {
            System.out.println("\"" + s + "\"" + " -> " + check4(s));
        }

        System.out.println("\nTest 5:");
        String[] str5 = {"10001", "7887", "929", "1010", "33"};
        for (String s : str5) {
            System.out.println("\"" + s + "\"" + " -> " + check5(s));
        }

        System.out.println("\nTest 6:");
        String[] str6 = {"1.35", "0.0", "-12.345", "-0.1", "3.0001", "2.030", "-00.1"};
        for (String s : str6) {
            System.out.println("\"" + s + "\"" + " -> " + check6(s));
        }


    }
}
