package leetcode.official;

import java.util.*;

public class Question49 {
    /**
     * 最终选择：1
     *
     * 1. 计算每个字符串字母频次的总 Hash 值，如果一致，扔到 List 里面去
     * 2. 给每个字符串排序，但是需要保留原数组，也即需要复制两份数组，空间消耗可能比较大
     * 而且排序最低 nlogn，遍历一次 n，时间为平方乘对数
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] frequencyArr = new char[26];
            // 统计词频
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            // 拼成 Key
            String key = new String(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
    }

    /**
     * 感觉两个效率差不多
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsSort(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            // 排序
            Arrays.sort(arr);
            // 拼成 Key
            String str = new String(arr);
            // Hash search
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
