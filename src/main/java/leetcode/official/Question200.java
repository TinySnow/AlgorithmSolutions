package leetcode.official;

public class Question200 {
    /**
     * 递归
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int counter = 0;
        // 遍历整个网络，因为是从前到后依次遍历并同时炸平岛屿，所以绝对不会出现炸平之后，需要再次遍历网络以确保没有岛屿这种情况
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果发现陆地，开始 DFS 递归将所有陆地炸平，再将岛屿数量 + 1
                if (grid[i][j] == '1') {
                    recursion(i, j, grid.length, grid[0].length, grid);
                    counter += 1;
                }
            }
        }
        return counter;
    }

    private static void recursion(int i, int j, int raw, int column, char[][] grid) {
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        if (j - 1 >= 0) recursion(i, j - 1, raw, column, grid);
        if (j + 1 < column) recursion(i, j + 1, raw, column, grid);
        if (i - 1 >= 0) recursion(i - 1, j, raw, column, grid);
        if (i + 1 < raw) recursion(i + 1, j, raw, column, grid);
    }
}
