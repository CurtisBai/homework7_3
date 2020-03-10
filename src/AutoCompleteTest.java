
import org.junit.Test;
import java.util.*;
import java.io.*;
import static org.junit.Assert.*;

public class AutoCompleteTest {

    @Test
    public void test01() {
        AutoComplete ac = new AutoComplete();
        ac.addWords("hello");
        ac.addWords("high");
        ac.addWords("seattle");
        ac.addWords("seatac");
        ac.addWords("see");
        ac.addWords("hollow");
        ac.addWords("how");

        Set<String> s;

        s = ac.searchText("h");
        assertTrue(checkSetWithStringArray(s, new String[]{"hello", "high", "hollow", "how"}));

        s = ac.searchText("se");
        assertTrue(checkSetWithStringArray(s, new String[]{"seattle", "see", "seatac"}));

        s = ac.searchText("sea");
        assertTrue(checkSetWithStringArray(s, new String[]{"seattle", "seatac"}));

        s = ac.searchText("ho");
        assertTrue(checkSetWithStringArray(s, new String[]{"how", "hollow"}));

        s = ac.searchText("xyz");
        assertTrue(checkSetWithStringArray(s, new String[]{}));

    }

    /**
     * check set and arr is equal or not
     *
     * @param set
     * @param arr
     * @return
     */
    private boolean checkSetWithStringArray(Set<String> set, String[] arr) {
        TreeSet<String> set2 = new TreeSet<>();
        for (String s : arr) {
            set2.add(s);
        }

        TreeSet<String> s1, s2;
        s1 = new TreeSet<String>(set);
        s2 = new TreeSet<String>(set2);
        s1.removeAll(s2);
        if (!s1.isEmpty()) {
            return false;
        }
        s1 = new TreeSet<String>(set);
        s2 = new TreeSet<String>(set2);
        s2.removeAll(s1);
        if (!s2.isEmpty()) {
            return false;
        }
        return true;
    }

}
