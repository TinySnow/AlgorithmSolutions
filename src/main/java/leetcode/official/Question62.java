package leetcode.official;

import java.util.Arrays;

public class Question62 {
    /**
     * 最终选择：DP，也只能 DP
     * 此解法是优化空间后的解法
     *
     * 注意，此优化有两个关键点：
     *
     * 1. dp[0] 其实是坐标原点，即最终的目的地，所以坐标轴横坐标方向是反着的
     *
     * start---------+   ^
     *  |            |   |
     *  +----------end   |
     * <-----------------+
     *
     * 2. dp 数组最开始全部赋值为 1，是因为最下面的一行只能往右走，不能往下走，所以走法只有 1
     * 然后自底向上，从 end 开始，往 start 计数，而非自顶向下
     *
     * @param m 一共 m 行
     * @param n 一共 n 列
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // 此循环，循环 m 次，自底向上，直到 start 那一行
        // 注意，每次循环将要开始时， dp 数组的初值不会清零，其值就是下面那一行的走法
        for (int i = 1; i < m; i++) {
            // 此循环，从 end 一直往左累加，直到 start 一列
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
