package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question17 {
    /**
     * 最终选择：1
     * <p>
     * 1. 递归深搜，差不多都是这种方法吧
     * 2. 迭代，这个没有想出来
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        char[][] letters = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        dfs(result, digits, 0, letters, "");
        return result;
    }

    private static void dfs(List<String> result, String digits, int idx, char[][] letters, String list) {
        if (idx == digits.length()) {
            result.add(list);
            return;
        }
        // 参数 idx 是 digits 中的下标位置，这里求的 i 是 letters 中的下标位置
        // 因为 digits 中的数字从 2 开始，而 letters 数组第一个下标值为 0，所以需要统一减一个 2
        int i = Integer.parseInt(String.valueOf(digits.charAt(idx))) - 2;
        for (int j = 0; j < letters[i].length; j++) {
            dfs(result, digits, idx + 1, letters, list + letters[i][j]);
        }
    }
}
