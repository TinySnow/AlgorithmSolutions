package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    private static List<String> result;

    /**
     * 最终选择：递归
     * <p>
     * 1. 递归，思路清晰
     * 2. 迭代，下一对括号，要么在里面（(())），要么在外面（()()）
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if (n < 0 || n > 8) {
            return null;
        }
        result = new ArrayList<>();
        recursion(0, 0, n, "");
        return result;
    }

    private static void recursion(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n)
            recursion(left + 1, right, n, s + "(");
        if (right < left)
            recursion(left, right + 1, n, s + ")");
    }
}
