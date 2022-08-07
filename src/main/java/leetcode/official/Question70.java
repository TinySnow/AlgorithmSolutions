package leetcode.official;

public class Question70 {
    /**
     * 1. 暴力递归，A(n)=A(n-1)+A(n-2)，递归出口 A(1)=1, A(2)=2, A(3)=A(1)+A(2)=3，此方法含有大量重复计算
     * 2. 优化 1 中方法，进行滚动数组加法计算，优化时间
     *
     * @param n 楼梯总数
     * @return
     */
    public static int climbStairs(int n) {
        // 边界判断
        if (n < 0 || n > 45) {
            return -1;
        }
        if (n < 4) {
            return n;
        }
        int total = 0;
        for (int i = 3, first = 1, second = 2; i <= n; i++) {
            total = first + second;
            first = second;
            second = total;
        }
        return total;
    }
}
