package leetcode.official;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        // 未进行边界判断
        // 每个单词
        StringBuffer word = new StringBuffer();
        // 单词 HashMap 用于计数
        HashMap<String, Integer> map = new HashMap<>();
        // 遍历每个字符
        for (int i = 0; i < paragraph.length(); i++) {
            // 取出当前字符
            char c = paragraph.charAt(i);
            // 总是返回小写
            char token = c >= 'A' && c <= 'Z' ? Character.toLowerCase(c) : c;
            // 如果是终结符，即标点符号或者空格
            if (token == ' ' || token == ',' || token == '.' || token == '?' || token == '!' || token == '\''|| token == ';') {
                // 转换为 String
                String s = word.toString();
                // 如果有连续的 标点+空格 或者 标点+标点 或者 空格+空格
                // 则在上一次的 标点 或者 标点 或者 空格（与上对应）时，就已经将单词推入 map 了
                // 所以在之后的 空格 或者 标点 或者 空格 时，s 应该是个空字符串
                // 如果是这种情况，就取反，不进入 if 推入 map 的流程
                if (!s.equals("")) {
                    // 推入 map
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    // 清空 StringBuilder 或者 StringBuffer
                    word.delete(0, word.length());
                }
                continue;
            }
            // 非终结符，也即字符，则继续加进去
            word.append(token);
            // 判断当前是否是位于字符串的最后一个单词，因为最后一个单词可能没有标点符号
            if (word.length() != 0 && i == paragraph.length() - 1) {
                map.put(word.toString(), map.getOrDefault(word.toString(), 0) + 1);
            }
        }
        // 去除 banned 单词
        for (String s : banned) {
            map.remove(s);
        }
        String historyString = "";
        Integer historyInteger = 0;
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        // 遍历 map
        for (Map.Entry<String, Integer> entry : set) {
            if (entry.getValue() > historyInteger) {
                historyString = entry.getKey();
                historyInteger = entry.getValue();
            }
        }
        // 返回频率最高的单词
        return historyString;
    }
}
