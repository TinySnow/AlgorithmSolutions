package leetcode.official;

import java.util.Stack;

public class Question9 {
    public boolean isPalindrome(int x) {
        // 转为 String 处理
        String s = String.valueOf(x);
        // 如果其长度小于 1，直接返回 true，没有必要进行后续处理
        if (s.length() <= 1) {
            return true;
        }
        // 生成栈
        Stack<Character> stack = new Stack<>();
        // 判断 String 长度的奇偶性，由此确定字符串的中间位置
        int middle = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        // 将 String 前一半压栈
        for (int i = 0; i < middle; i++) {
            stack.push(s.charAt(i));
        }
        // 如果 String 长度为奇数，则需弹出一个字符
        // 注意：
        // 其前确定中间位置时，是根据长度确定，而非下标
        // 而压栈时是根据下标压栈，所以中间位置在数值上要比压栈时的计数变量 i 值多 1
        // 也即，此时奇数变量字符串的中间位置字符也已经压入栈中
        // 举例说明：
        // String s = "aba"
        // middle = 3 / 2 + 1 = 2
        // 而 s[2] = a
        // 当遇到 i < 2 时跳出上面的循环
        // 但跳出时，此处的 "b" 中间位置字符已经被压入栈中
        // 所以需要弹出
        if (s.length() % 2 == 1) {
            stack.pop();
        }
        // 出栈时比较栈中字符和后续字符
        // 一旦不一致则返回 false
        for (int i = middle; i < s.length(); i++) {
            if (stack.pop() != s.charAt(i)) {
                return false;
            }
        }
        // 能到达这里即说明已经通过所有的测试，返回 true 即可
        return true;
    }
}
