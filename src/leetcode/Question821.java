package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question821 {
    public static int[] shortestToChar(String s, char c) {
        // 边界判定
        if (s.length() > 10000) {
            return null;
        }
        // c 的下标 list
        List<Integer> idx = new ArrayList<>();
        // 结果 list
        List<Integer> result = new ArrayList<>();
        // 遍历第一次，记录 c 出现的下标
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                idx.add(i);
            }
        }
        // 下标 list 中的 index
        int inIdx = 0;
        // c 的前一个出现的位置
        Integer pre = 0;
        // c 的后一个出现的位置
        Integer later = idx.get(inIdx);
        // 最终取哪一个比较接近
        int choice;
        // 开始第二次遍历，输出结果
        for (int i = 0; i < s.length(); i++) {
            // 如果字符 c 为第一次出现或者最后一次出现，
            // 则 pre 会为 0 或者 later 会为 size - 1
            // 需要对这两种情况特殊处理
            if (i <= idx.get(0)) {
                // 如果 pre 为 0，则让所有出现在第一次 c 之前的位置直接减去 c 所处的下标，
                // 也即最终的 choice 是 later，因为 pre 为 0
                if (i == idx.get(0)){
                    pre = later;
                    later = idx.get(inIdx++);
                }
                result.add(Math.abs(i - idx.get(0)));
            } else if (i >= idx.get(idx.size() - 1)) {
                // 如果 later 为 size - 1，则让所有出现在最后一次 c 之后的位置直接减去 c 所处的下标，
                // 也即最终的 choice 是 pre，因为 later = s.size - 1
                if (i == idx.get(idx.size() - 1)){
                    pre = later;
                    later = s.length() - 1;
                }
                result.add(Math.abs(i - idx.get(idx.size() - 1)));
            }
            // 否则进入此处，即循环中部，
            // 我们需要判断当前字符所处的位置 i 与 pre 更接近还是与 later 更接近
            // 所以需要取 pre 和 later 的平均值（中间值），
            // 如果 i 低于中间值，与 pre 更接近；
            // 如果 i 高于中间值，与 later 更接近。
            // 而 / 默认向下取整，所以遇到除 2 剩 0.5 的情况（例如 (0 + 3) / 2），
            // 我们需要加上等于（在上述例子中，如果 i <= 1，则 choice 取 pre，i > 1，则 choice 取 later）
            // 一旦 i 等于或越过 later，我们需要将 later 赋值给 pre，然后取新的 later
            else {
                if (i >= later) {
                    pre = later;
                    later = idx.get(inIdx++);
                }
                choice = i <= (pre + later) / 2 ? pre : later;
                result.add(Math.abs(i - choice));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

/**
 * 以下为宫水三叶的代码
 * 思路与官方思路相同
 * 先找左，再找右，然后取最小值
 * 更简洁而且效率更高
 */
//        int n = s.length();
//        int[] ans = new int[n];
//        Arrays.fill(ans, n + 1);
//        for (int i = 0, j = -1; i < n; i++) {
//            if (s.charAt(i) == c) j = i;
//            if (j != -1) ans[i] = i - j;
//        }
//        for (int i = n - 1, j = -1; i >= 0; i--) {
//            if (s.charAt(i) == c) j = i;
//            if (j != -1) ans[i] = Math.min(ans[i], j - i);
//        }
//        return ans;
    }
}
