
import java.util.*;
import java.io.*;

public class AutoComplete {

    TreeMap<String, TreeSet<String>> wordTable;

    public AutoComplete() {
        wordTable = new TreeMap<String, TreeSet<String>>();
    }

    public void addWords(String word) {
        word = word.trim().toLowerCase();
        for (int i = 1; i <= word.length(); i++) {
            String sub = word.substring(0, i);
            // System.out.println(sub);
            if (!wordTable.containsKey(sub)) {
                wordTable.put(sub, new TreeSet<String>());
            }
            wordTable.get(sub).add(word);
        }

    }

    public TreeSet<String> searchText(String word) {
        word = word.trim().toLowerCase();
        if (wordTable.containsKey(word)) {
            return wordTable.get(word);
        } else {
            return new TreeSet<String>();
        }
    }

    public static void main(String args[]) {
        AutoComplete ac = new AutoComplete();
        ac.addWords("Apple");
        ac.addWords("ppac");
        ac.addWords("apk");
        ac.addWords("applelike");
        ac.addWords("papapa");

    }

}
