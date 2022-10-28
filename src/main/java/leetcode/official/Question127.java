package leetcode.official;

import java.util.*;

/**
 * 未通过，寄
 */
public class Question127 {
    /**
     * 以下为单向 BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 边界判断
        if (beginWord == null || endWord == null || wordList == null) return -1;

        // Hash 查询均摊 O(1)，所以此处另建
        HashSet<String> set = new HashSet<>(wordList);
        // 如果单词表没有单词，或者 end 不在单词表里，直接返回 0，因为不可能成功
        if (set.size() == 0 || !set.contains(endWord)) return 0;
        // 同时移除单词表里的 begin（如果有的话）
        set.remove(beginWord);

        // BFS 模板，队列和 visited，后者为了防止走回去，然后 Stackoverflow
        Deque<String> dq = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        dq.add(beginWord);

        // BFS 其实也是层次遍历，所以此处也可更名为层数（level）
        int step = 1;
        while (!dq.isEmpty()) {
            // 固定刚开始的 size，防止 deque 的 size 动态变化而出问题（重要）
            int size = dq.size();
            // 遍历该层
            for (int i = 0; i < size; i++) {
                String s = dq.poll();
                // 如果有符合的元素添加到下一层，这一块的逻辑封装到 match 函数里了
                // 如果能匹配到的话，直接当前层加一即可
                // 不能匹配到就遍历下一层，同时 step++
                if (match(s, endWord, dq, visited, set))
                    return step + 1;
            }
            step++;
        }
        // 到这里说明 dq 遍历完了都没能找到，说明不可达，直接返回 0
        return 0;
    }

    private static boolean match(String current, String end, Deque<String> dq, HashSet<String> visited, HashSet<String> set) {
        StringBuilder sb = new StringBuilder(current);
        // 固定 size，不过因为 sb 不涉及 delete 和 insert 操作，所以其实可以内联到 for 里去
        int size = sb.length();
        for (int i = 0; i < size; i++) {
            // 保存原来 car 当中的 'c' 'a' 'r'，后面会替换
            char origin = sb.charAt(i);
            // 对每个 sb 位置上的 char 尝试替换其他字母，看看是否在单词表里
            for (char c = 'a'; c <= 'z'; c++) {
                // 原字符就跳过
                if (c == origin) continue;
                // 尝试替换后的字符串
                String s = sb.replace(i, i + 1, String.valueOf(c)).toString();
                // 在单词表里
                if (set.contains(s)) {
                    // 若为 end 直接返回 true 说明找到了
                    if (s.equals(end)) return true;
                    // 否则直接加入队列
                    // 不过注意此处加一个条件，没有走回去
                    // 比如 "hot" -> "hit" -> "hot" -> "hit" 这样是不行的
                    // 这也是 visited 存在的意义
                    if (!visited.contains(s)) {
                        // 符合条件则加到 dq 里面去
                        dq.add(s);
                        visited.add(s);
                    }
                }
            }
            // 还原
            sb.replace(i, i + 1, String.valueOf(origin));
        }
        return false;
    }
}
