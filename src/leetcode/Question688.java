package leetcode;

/**
 * UNFINISHED
 * DP 杀我
 */
public class Question688 {
    public double knightProbability(int n, int k, int row, int column) {
//        if (n < 1 || n > 25 || k < 0 || k > 100 || row < 0 || row > n || column < 0 || column > n) {
//            return 0.0;
//        }
//        Integer rowDown2 = row + 2 < n ? row + 2 : null;
//        Integer rowUp2 = row - 2 > 0 ? row - 2 : null;
//        Integer colLeft2 = column - 2 > 0 ? column - 2 : null;
//        Integer colRight2 = column + 2 > n ? column + 2 : null;
//        judge(n, k, rowUp2, rowUp2, column - 1);
//        judge(n, k, rowUp2, rowUp2, column + 1);
//        judge(n, k, rowDown2, rowDown2, column - 1);
//        judge(n, k, rowDown2, rowDown2, column + 1);
//        judge(n, k, colLeft2, row - 1, colLeft2);
//        judge(n, k, colLeft2, row + 1, colLeft2);
//        judge(n, k, colRight2, row - 1, colRight2);
//        judge(n, k, colRight2, row + 1, colRight2);
//        return 0.0;
//    }
//
//    public void judge(int n, int k, Integer judge, Integer row, Integer column) {
//        if (judge != null) {
//            knightProbability(n, k - 1, row, column);
//            knightProbability(n, k - 1, row, column);
//        }
        /**
         * 以下为官方题解
         */
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
}
