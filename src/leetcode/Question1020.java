package leetcode;

import java.util.Stack;

public class Question1020 {
    public static int numEnclaves(int[][] grid) {
        // 边界确定
        if (grid.length < 1 || grid.length > 500 || grid[0].length < 1 || grid[0].length > 500) {
            return 0;
        }
        // DFS 需要用栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < grid[0].length; i++) {
            // 遍历第一行
            if (grid[0][i] == 1) {
                dfs(grid, 0, i, stack);
            }
            // 遍历最后一行
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i, stack);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            // 遍历第一列
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, stack);
            }
            // 遍历最后一列
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1, stack);
            }
        }
        // 因为能出去的陆地都被我们变成海洋了，所以此时如果仍为陆地
        // 那么说明这个陆地便是孤岛
        int count = 0;
        // 遍历每一行
        for (int[] ints : grid) {
            // 遍历每一列
            for (int i : ints) {
                if (i == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int row, int column, Stack<Integer> stack) {
        // 先推入栈
        stack.push(grid[row][column]);
        // 然后将其变为海洋
        grid[row][column] = 0;
        // 是否出于网格第一行
        Integer top = row == 0 ? null : row - 1;
        // 是否处于网格最后一行
        Integer bottom = row == grid.length - 1 ? null : row + 1;
        // 是否处于网格第一列
        Integer left = column == 0 ? null : column - 1;
        // 是否处于网格最后一列
        Integer right = column == grid[0].length - 1 ? null : column + 1;
        judge_row(grid, column, stack, top);
        judge_row(grid, column, stack, bottom);
        judge_column(grid, row, stack, left);
        judge_column(grid, row, stack, right);
        // 四周都是海了就弹出来
        stack.pop();
    }

    private static void judge_column(int[][] grid, int row, Stack<Integer> stack, Integer column) {
        if (column != null) {
            if (grid[row][column] == 1) {
                dfs(grid, row, column, stack);
            }
        }
    }

    private static void judge_row(int[][] grid, int column, Stack<Integer> stack, Integer row) {
        if (row != null) {
            if (grid[row][column] == 1) {
                dfs(grid, row, column, stack);
            }
        }
    }
}
