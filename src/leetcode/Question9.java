package leetcode;

import java.util.Stack;

public class Question9 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.length() <= 1){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int middle = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        for (int i = 0; i < middle; i++) {
            stack.push(s.charAt(i));
        }
        if (s.length() % 2 == 1) {
            stack.pop();
        }
        for (int i = middle; i < s.length(); i++) {
            if (stack.pop() != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
