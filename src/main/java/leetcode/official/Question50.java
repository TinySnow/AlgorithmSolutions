package leetcode.official;

public class Question50 {
    public static double myPow(double x, int n) {
        // TODO: 未完成
        if (n == 0) return 1.0;
        else if (n == 1) return x;
        else if (n == -1) return 1 / x;
        else {
            double v = myPow(x, n / 2);
            return v * v * (n % 2 == 0 ? 1 : (n > 0 ? x : 1 / x));
        }
    }
}
