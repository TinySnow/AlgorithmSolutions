package leetcode.official;

/**
 * 好难
 */
public class Question37 {
    public void solveSudoku(char[][] board) {
        if (board == null) return;
        boolean[][] raws = new boolean[9][9], cols = new boolean[9][9], block = new boolean[9][9];
        // 先扫一遍棋盘
        scan(board, raws, cols, block);
        // 回溯
        backtracing(board, raws, cols, block);
    }

    private void scan(char[][] board, boolean[][] raws, boolean[][] cols, boolean[][] block) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = i / 3 * 3 + j / 3;
                    int num = c - '1';
                    raws[i][num] = cols[j][num] = block[idx][num] = true;
                }
            }
        }
    }

    private boolean backtracing(char[][] board, boolean[][] raws, boolean[][] cols, boolean[][] block) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    for (int k = 0; k < 9; k++) {
                        if (valid(i, j, k, raws, cols, block)) {
                            int idx = i / 3 * 3 + j / 3;
                            board[i][j] = (char) (k + '1');
                            raws[i][k] = cols[j][k] = block[idx][k] = true;
                            if (backtracing(board, raws, cols, block)) return true;
                            raws[i][k] = cols[j][k] = block[idx][k] = false;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(int i, int j, int num, boolean[][] raws, boolean[][] cols, boolean[][] block) {
        int idx = i / 3 * 3 + j / 3;
        return !raws[i][num] && !cols[j][num] && !block[idx][num];
    }
}
