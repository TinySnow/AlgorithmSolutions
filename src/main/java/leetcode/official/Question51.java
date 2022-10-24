package leetcode.official;

import java.util.*;

/**
 * 提交代码时，需要去掉方法和字段的 static 标识，否则会出错
 */
public class Question51 {
    private static final List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        if (n < 1) return result;
        // 生成棋盘
        char[][] board = generate(n);
        // 回溯
        backtracing(board, 0);
        return result;
    }

    private static void backtracing(char[][] board, int raw) {
        // 走到最后，即皇后之间不会打架
        if (raw == board.length) {
            result.add(converter(board));
            return;
        }
        int len = board[raw].length;
        // 每一个列上均可能放置皇后
        for (int col = 0; col < len; col++) {
            // 如果皇后放置不合法，立即剪枝
            if (!isValid(board, raw, col)) continue;
            // 尝试放置皇后
            board[raw][col] = 'Q';
            // 继续递归
            backtracing(board, raw + 1);
            // 恢复原状态
            board[raw][col] = '.';
        }
    }

    /**
     * 校验皇后之间是否打架
     * 此处直接硬算
     * 也可以将其加入 横，竖，主对角线，副对角线 的 List/Array 中判断
     *
     * @param board
     * @param raw
     * @param col
     * @return
     */
    private static boolean isValid(char[][] board, int raw, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[raw].length; j++) {
                if (board[i][j] == 'Q' && (j == col || i + j == raw + col || i - j == raw - col))
                    return false;
            }
        }
        return true;
    }

    /**
     * 将棋盘从 char 转为要求的格式
     *
     * @param board
     * @return
     */
    private static List<String> converter(char[][] board) {
        ArrayList<String> result = new ArrayList<>();
        for (char[] chars : board) {
            result.add(new String(chars));
        }
        return result;
    }

    /**
     * 生成棋盘
     *
     * @param n
     * @return
     */
    private static char[][] generate(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }
}
