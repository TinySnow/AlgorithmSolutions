package leetcode.official;

public class Question231 {
    public boolean isPowerOfTwo(int n) {
        if (n == -2147483648) return false;
        return Integer.bitCount(n) == 1;
    }
}
