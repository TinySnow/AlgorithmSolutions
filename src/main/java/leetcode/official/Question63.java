package leetcode.official;

public class Question63 {
    /**
     * 最终选择：DP
     * 此题为 62 题进阶版
     *
     * 注意：
     * 若最底行某一点有障碍物，则往 x 轴方向走的时候，因为均不能抵达终点，所以均置为 0，跳出循环即可
     * 若最右列某一点有障碍物，则往 y 轴方向走的时候，因为均不能抵达终点，所以均置为 0，跳出循环即可
     *
     * start---------+   ^ y
     *  |            |   |
     *  +----------end   |
     * <-----------------+
     * x
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return -1;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            else dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            else dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
