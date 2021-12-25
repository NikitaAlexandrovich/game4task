package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        if (args.length > 3 || args.length % 2 != 0) {
            List<String> startParams = new ArrayList<>();
            Set<String> uniqueItems = new TreeSet<>();
            for (String s : args) {
                startParams.add(s);
                if (!uniqueItems.add(s)) {
                    System.out.println("All parameters can be different!");
                    return;
                }
            }
            Game game = new Game(startParams);
        } else {
            System.out.println("The number of parameters must be odd and equal to or greater than 3.");
        }
    }
}
