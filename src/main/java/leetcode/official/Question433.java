package leetcode.official;

import java.util.*;

public class Question433 {
    public static int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null) return -1;
        Set<String> sets = new HashSet<>(Arrays.asList(bank));
        if (sets.size() == 0 || !sets.contains(end)) return -1;
        sets.remove(start);

        Set<String> top = new HashSet<>();
        Set<String> bottom = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] gene = {'A', 'G', 'C', 'T'};

        top.add(start);
        bottom.add(end);
        visited.add(start);

        int step = 0;

        // 双向 BFS
        while (!top.isEmpty() && !bottom.isEmpty()) {
            // 每次先挑 size 最小的 set 扩散
            if (top.size() > bottom.size()) {
                Set<String> tmp = top;
                top = bottom;
                bottom = tmp;
            }
            Set<String> level = new HashSet<>();
            for (String s : top) {
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < sb.length(); i++) {
                    // 保存
                    char origin = sb.charAt(i);
                    for (char c : gene) {
                        if (origin == c) continue;
                        String after = sb.replace(i, i + 1, String.valueOf(c)).toString();
                        if (bottom.contains(after)) return step + 1;
                        if (!visited.contains(after) && sets.contains(after)) {
                            level.add(after);
                            visited.add(after);
                        }
                    }
                    // 还原
                    sb.replace(i, i + 1, String.valueOf(origin));
                }
            }
            // 注意：此处 top 重新赋值，直接扔掉以前 level 的所有结点，因为不需要
            top = level;
            step++;
        }
        return -1;
    }
}
