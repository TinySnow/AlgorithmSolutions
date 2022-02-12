package leetcode;

import java.util.Stack;

public class Question1020 {
    public static int numEnclaves(int[][] grid) {
        if (grid.length < 1 || grid.length > 500 || grid[0].length < 1 || grid[0].length > 500) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i, stack);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i, stack);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, stack);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1, stack);
            }
        }
        int count = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int row, int column, Stack<Integer> stack) {

        stack.push(grid[row][column]);
        grid[row][column] = 0;
        Integer top = row == 0 ? null : row - 1;
        Integer bottom = row == grid.length - 1 ? null : row + 1;
        Integer left = column == 0 ? null : column - 1;
        Integer right = column == grid[0].length - 1 ? null : column + 1;
        if (top != null) {
            if (grid[top][column] == 1) {
                dfs(grid, top, column, stack);
            }
        }
        if (bottom != null) {
            if (grid[bottom][column] == 1) {
                dfs(grid, bottom, column, stack);
            }
        }
        if (left != null) {
            if (grid[row][left] == 1) {
                dfs(grid, row, left, stack);
            }
        }
        if (right != null) {
            if (grid[row][right] == 1) {
                dfs(grid, row, right, stack);
            }
        }
        stack.pop();
    }
}
