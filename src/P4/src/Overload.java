package P4.src;

// Michelle Pohl
public class Overload {

    public static String concat(String s1, String s2) {

        return s1 + s2;
    }

    // Überladung 1: Wiederholt den String n-mal
    public static String concat(int n, String s) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
        return result;
    }

    // Überladung 2: Verbindet ein Array von Strings mit einem Trennzeichen
    public static String concat(String[] strings, char separator) {
        String result = strings[0];
        for (int i = 1; i < strings.length; i++) {
            result += separator + strings[i];
        }
        return result;
    }

    // 1.5
    public static void main(String[] args) {
        String s1 = "a", s2 = "b", s3 = "c";
        char c = '-';

        // abcabcabc
        System.out.println(concat(3, concat(s1, concat(s2, s3))));

        // abbccc
        System.out.println(concat(1, s1) + concat(2, s2) + concat(3, s3));

        // aaa-bbb-ccc
        System.out.println(concat(new String[]{
                concat(3, s1), concat(3, s2), concat(3, s3)
        }, c));
    }
}


