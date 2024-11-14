package P9.src;

public class RegEx{

    public static boolean check1(String s){
	return false; // dummy return
    }

    public static boolean check2(String s){
	return false; // dummy return
    }

    public static boolean check3(String s){
	return false; // dummy return
    }

    public static boolean check4(String s){
	return false; // dummy return
    }

    public static boolean check5(String s){
	return false; // dummy return
    }

    public static boolean check6(String s){
	return false; // dummy return
    }


    public static void main(String[] args){
	System.out.println("Test 1:");
	System.out.println("Die Zeichenkette enthaelt ausschließlich Grossbuchstaben \nund Zwischenraumzeichen (aber ist nicht leer).");
	String[] str1 = {"","ABcDE","A","a", "  ", "X Y  Z"};
	for (String s : str1){
	    System.out.println("\"" + s + "\"" + " -> " + check1(s));
	}


	System.out.println("\nTest 2:");
	System.out.println("Die Zeichenkette enthält mindestens einen Großbuchstaben");
	String[] str2 = {"abcDefg", "A","a","","12345X"};
	for (String s : str2){
	    System.out.println("\"" + s + "\"" + " -> " + check2(s));
	}

	System.out.println("\nTest 3:");
	System.out.println("Die Zeichenkette endet mit einem Untertrich, gefolgt von einer oder zwei Ziffern");
	String[] str3 = {"x_0","abc_12","_123_12", "_12_123"};
	for (String s : str3){
	    System.out.println("\"" + s + "\"" + " -> " + check3(s));
	}

	System.out.println("\nTest 4:");
	System.out.println("Die Zeichenkette beginnt und endet mit der gleichen Ziffer ");
	String[] str4 = {"1abc1","90079","1abc9"};
	for (String s : str4){
	    System.out.println("\"" + s + "\"" + " -> " + check4(s));
	}

	System.out.println("\nTest 5:");
	System.out.println("Die Zeichenkette repraesentiert eine Schnapszahl der Laenge 2, 3 oder 4.");
	String[] str5 = {"0000","11","9999","11011","5555555555"};
	for (String s : str5){
	    System.out.println("\"" + s + "\"" + " -> " + check5(s));
	}

	System.out.println("\nTest 6:");
	System.out.println("Die Zeichenkette enthält eine gerade Anzahl von + Zeichen");
 	String[] str6 = {"a-b-c-d","+ab+c","123+++X+YZ","++ UUU +++ !!! +","*-/", "+++"};
	for (String s : str6){
	    System.out.println("\"" + s + "\"" + " -> " + check6(s));
	}
   }
}
