package leetcode.official;

import java.util.Deque;
import java.util.LinkedList;

public class Question921 {
    /**
     * 最终选择：2
     * 注释的为自己写的，下面的是题解，题解更快
     * 1. 贪心栈
     * 2. 分数制（投票法）
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
//        Deque<Character> queue = new LinkedList<>();
//        int cnt = 0;
//        for (char c : s.toCharArray()) {
//            if (c == '(') queue.add('(');
//            else if (queue.isEmpty()) cnt++;
//            else queue.poll();
//        }
//        return cnt + queue.size();

        int ans = 0, left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (left > 0) left--;
            else ans++;
        }
        return ans + left;
    }
}
