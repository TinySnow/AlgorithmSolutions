package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Question884 {
    public static String[] uncommonFromSentences(String s1, String s2) {
        // 分割单词
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");
        // HashMap 记录出现次数
        HashMap<String, Integer> map = new HashMap<>();
        // 下标变量
        int s1Flag = 1;
        int s2Flag = 1;
        // 直到两单词数组都遍历完为止，一直循环，注意此处判断条件
        // 两单词数组如果有一个还没遍历完，则会一直循环
        while (s1Flag != s1Words.length + 1 || s2Flag != s2Words.length + 1) {
            // 各自判断
            if (s1Flag <= s1Words.length) {
                if (map.containsKey(s1Words[s1Flag - 1])) {
                    // 出现重复字符，重复次数加一
                    map.replace(s1Words[s1Flag - 1], map.get(s1Words[s1Flag - 1]) + 1);
                } else {
                    // 否则将新出现的字符放进 HashMap
                    map.put(s1Words[s1Flag - 1], 1);
                }
                // 下标值加一
                s1Flag++;
            }
            // 与上相同
            if (s2Flag <= s2Words.length) {
                if (map.containsKey(s2Words[s2Flag - 1])) {
                    map.replace(s2Words[s2Flag - 1], map.get(s2Words[s2Flag - 1]) + 1);
                } else {
                    map.put(s2Words[s2Flag - 1], 1);
                }
                s2Flag++;
            }
        }
        // 新建结果集
        ArrayList<String> list = new ArrayList<>();
        // 遍历 HashMap 键值
        for (String s : map.keySet()) {
            // 判断出现次数，小于 1 则加入结果集 list
            if (map.get(s) <= 1) {
                list.add(s);
            }
        }
        // 返回 String[]
        return list.toArray(new String[0]);
    }
}
