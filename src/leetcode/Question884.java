package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Question884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int s1Flag = 1;
        int s2Flag = 1;
        while (s1Flag != s1Words.length + 1 || s2Flag != s2Words.length + 1) {
            if (s1Flag <= s1Words.length) {
                if (map.containsKey(s1Words[s1Flag - 1])) {
                    map.replace(s1Words[s1Flag - 1], map.get(s1Words[s1Flag - 1]) + 1);
                } else {
                    map.put(s1Words[s1Flag - 1], 1);
                }
                s1Flag++;
            }
            if (s2Flag <= s2Words.length) {
                if (map.containsKey(s2Words[s2Flag - 1])) {
                    map.replace(s2Words[s2Flag - 1], map.get(s2Words[s2Flag - 1]) + 1);
                } else {
                    map.put(s2Words[s2Flag - 1], 1);
                }
                s2Flag++;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) <= 1) {
                list.add(s);
            }
        }
        return list.toArray(new String[0]);
    }
}
