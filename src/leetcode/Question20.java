package leetcode;

import java.util.Stack;

public class Question20 {
    public static boolean isValid(String s) {
        // 栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 取出括号
            char sub = s.charAt(i);
            // 前括号进栈
            if (sub == '(' || sub == '[' || sub == '{') {
                stack.push(sub);
            } else if (sub == ')' || sub == ']' || sub == '}') {
                // 判断
                char pair = '(';
                if (sub == ']') {
                    pair = '[';
                } else if (sub == '}') {
                    pair = '{';
                }
                if (stack.isEmpty() || stack.peek() != pair) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();


/**
 * 以下为差不多的官方解法
 */
//        // 栈
//        Stack<Character> stack = new Stack<>();
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put(']', '[');
//        map.put('}', '{');
//        for (int i = 0; i < s.length(); i++) {
//            // 取出括号
//            char sub = s.charAt(i);
//            if (map.containsValue(sub)) {
//                stack.push(sub);
//            } else {
//                if (stack.isEmpty() || stack.peek() != map.get(sub)) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//        return stack.isEmpty();
    }
}
