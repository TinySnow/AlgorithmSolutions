package leetcode;

import java.util.Collections;
import java.util.HashSet;

public class Question824 {
    public String toGoatLatin(String sentence) {
        // 边界判断
        if (sentence.length() < 1 || sentence.length() > 150) {
            return null;
        }
        // 结果 builder
        StringBuilder result = new StringBuilder();
        // 原因 HashSet，用于判断
        HashSet<Character> vowel = new HashSet<>(10);
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        // 依据空格分割字符串，得到每个单词的 String 数组
        String[] s = sentence.split(" ");
        // 遍历每个单词
        for (int i = 0; i < s.length; i++) {
            // 对每个单词进行改造，builder 初始化为当前单词
            StringBuilder word = new StringBuilder(s[i]);
            // 首字母
            char c = s[i].charAt(0);
            // 如果首字母是元音，则不必执行这一步，所以取了反
            // 这是辅音所做的工作，删除第一个字符，然后将这个字符追加到末尾
            if (!vowel.contains(c)) {
                word.delete(0, 1);
                word.append(c);
            }
            // 追加 "ma"
            word.append("ma");
//            word.append(String.join("", Collections.nCopies(i,"a")));
            // 根据 index 决定追加多少个 "a"
            for (int j = 0; j < i + 1; j++) {
                word.append('a');
            }
            // 最后再追加一个空格
            word.append(' ');
            // 拼到 result 上去
            result.append(word);
        }
        // 返回 result 去除最后一个单词末尾的空格后的结果
        return result.delete(result.length() - 1, result.length()).toString();
    }
}
