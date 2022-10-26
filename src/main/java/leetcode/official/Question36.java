package leetcode.official;

public class Question36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;
        boolean[][] raw = new boolean[10][10], col = new boolean[10][10], block = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if (raw[i][num] || col[j][num] || block[idx][num]) return false;
                raw[i][num] = col[j][num] = block[idx][num] = true;
            }
        }
        return true;
    }
}
