package leetcode;

import java.util.*;

public class Question804 {
    public int uniqueMorseRepresentations(String[] words) {
        // 边界判断
        if (words.length<1||words.length>100){
            return 0;
        }
        // 映射表
        Map<Character, String> map = new HashMap<>();
        map.put('a',".-");
        map.put('b',"-...");
        map.put('c',"-.-.");
        map.put('d',"-..");
        map.put('e',".");
        map.put('f',"..-.");
        map.put('g',"--.");
        map.put('h',"....");
        map.put('i',"..");
        map.put('j',".---");
        map.put('k',"-.-");
        map.put('l',".-..");
        map.put('m',"--");
        map.put('n',"-.");
        map.put('o',"---");
        map.put('p',".--.");
        map.put('q',"--.-");
        map.put('r',".-.");
        map.put('s',"...");
        map.put('t',"-");
        map.put('u',"..-");
        map.put('v',"...-");
        map.put('w',".--");
        map.put('x',"-..-");
        map.put('y',"-.--");
        map.put('z',"--..");
        // 创建迭代器
        Iterator<String> iterator = Arrays.stream(words).iterator();
        // 每个结果扔进 HashSet 看看是否重复
        Set<String> set = new HashSet<>();
        // 为每个单词的摩斯电码创建一个 buffer 用于拼接
        StringBuffer buffer = new StringBuffer(words.length);
        // 消费和迭代
        iterator.forEachRemaining(s -> {
            for (int i = 0; i < s.length(); i++) {
                // 依次取出字母
                char c = s.charAt(i);
                // 拼接进 buffer
                buffer.append(map.get(c));
            }
            // 扔进 Hashset
            set.add(buffer.toString());
            // 清空 buffer
            buffer.delete(0,buffer.length());
        });
        return set.size();
    }
}
