package leetcode.official;

import java.util.Arrays;
import java.util.HashMap;

public class Question242 {
    /**
     * 最终选择：Hash
     * <p>
     * 1. 排序，看两个字符串是否是相等的
     * 2. Hash 统计字母频率，一边加一边减，看是否为空
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return false;
            }
        }
        return true;


//        这个人的比较有参考价值
//        int[] alphabet = new int[26];
//        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//        for (int i : alphabet) if (i != 0) return false;
//        return true;
    }

    /**
     * 排序法
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagramSort(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }
}
