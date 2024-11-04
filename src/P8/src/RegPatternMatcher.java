package P8.src;// Michelle Pohl
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegPatternMatcher {

    /* *** Aufgabenteil (a) *** */
    // 2
    public static void findAdverbs(String text) {

        Pattern adverbPattern = Pattern.compile("\\b[A-Za-z]+ly\\b");
        Matcher matcher = adverbPattern.matcher(text);

        StringBuilder adverbs = new StringBuilder();
        int count = 0;

        while (matcher.find()) {
            adverbs.append(matcher.group()).append(" ");
            count++;
        }

        // Ausgabe der Ergebnisse
        System.out.println("The text \"" + text + "\"");
        System.out.println("contains " + count + " adverb(s): " + adverbs.toString().trim());
    }

    /* *** Aufgabenteil (b) *** */
    // 3*
    public static void findRecipesWithoutChocolate(String recipes) {

        String regex = "(Cake \\d+:.*?)(?<!chocolate)(?=\n)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(recipes);

        while (matcher.find()) {
            String recipe = matcher.group(1).trim();
            // Überprüfen, ob 'chocolate' im Rezept vorkommt
            if (!recipe.toLowerCase().contains("chocolate")) {
                System.out.println(recipe);
            }
        }
    }

    /* *************  Testaufrufe ************** */

    public static void main(String[] args) {

        String t3 = "He was happily, crazily, foolishly over the moon."; // 3
        String t4 = "The horse acted aggressively and stubbornly.";      // 2
        String t5 = "She forgot where to buy the lysol.";                // 0
        String t6 = "She writes poetry beautifully.";                    // 1
        String t7 = "Ilya ran to the store.";                            // 0

        for (String t : new String[]{t3, t4, t5, t6, t7}) {
            findAdverbs(t);
        }

        String recipeList =
                "Cake 1: sugar, flour, cocoa powder, baking powder, baking soda, salt, eggs, milk, vegetable oil, vanilla extract, chocolate chips \n" +
                        "Cake 2: cream cheese, sugar, vanilla extract, crescent rolls, cinnamon, butter, honey  \n" +
                        "Cake 3: dark chocolate cake mix, instant chocolate pudding mix, sour cream, eggs, vegetable oil, coffee liqueur \n" +
                        "Cake 4: flour, baking powder, salt, cinnamon, butter, sugar, egg, vanilla extract, milk, chopped walnuts  \n" +
                        "Cake 5: gingersnap cookies, chopped pecans, butter, cream cheese, sugar, vanilla extract, eggs, canned pumpkin, cinnamon  \n" +
                        "Cake 6: flour, baking soda, sea salt, butter, white sugar, brown sugar, eggs, vanilla extract, chocolate chips, canola oil  \n" +
                        "Cake 7: wafers, cream cheese, sugar, eggs, vanilla extract, cherry pie filling \n";

        findRecipesWithoutChocolate(recipeList);

    }
}
