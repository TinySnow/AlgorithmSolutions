package leetcode;

import java.util.HashMap;

public class Question1189 {
    public static int maxNumberOfBalloons(String text) {
        // 边界确定
        if (text.length() < 1 || text.length() > 10000) {
            return 0;
        }
        // 存放相应值
        HashMap<Character, Integer> map = new HashMap<>();
        // 放入相应的字母
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);
        // 遍历字符串，统计这五个字母出现的次数
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.replace(c, map.get(c) + 1);
            }
        }
        Character[] array = map.keySet().toArray(new Character[0]);
        // 能拼成的单词数量
        int result = Integer.MAX_VALUE;
        // 遍历键集
        for (Character character : array) {
            // 因为 balloon 当中，l 和 o 出现了两次，所以要拼成一个单词时，其出现次数要除以 2
            if (character.equals('l') || character.equals('o')) {
                map.replace(character, map.get(character) / 2);
            }
            // 取最小值，即为能拼成单词的最小数目
            result = Math.min(map.get(character), result);
        }
        return result;
    }
}
