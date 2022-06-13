package leetcode.official;

import java.util.HashMap;

/**
 * 根据滑动窗口思想进行算法处理
 */
public class Question3 {
    public static int lengthOfLongestSubstring(String s) {
        // 长度判断，过短可以直接返回
        if (s.length() <= 1) {
            return s.length() == 0 ? 0 : 1;
        }
        int startIndex = 0;
        int endIndex = 0;
        int currentMaxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (map.containsKey(character)) {
                // 如果遇到重复字符，进入此 if

                // 首先计算上次的最大值
                currentMaxLength = Math.max(endIndex - startIndex + 1, currentMaxLength);
                // 然后将重复字符上次出现的下标取出来，赋值给需要重新计算的开始下标，并且下标需要加上 1
                // 用以略过上次重复字符，否则会出现两次重复字符
                if (map.get(character) >= startIndex) {
                    startIndex = map.get(character) + 1;
                }
                // 更新重复字符的下标值
                map.replace(character, i);
            } else {
                // 否则放到 map 里面，进行下一循环
                map.put(character, i);
            }
            endIndex = i;
        }
        return Math.max(endIndex - startIndex + 1, currentMaxLength);
    }
}
