package leetcode.official;

public class Question74 {
    /**
     * 最终选择：1
     * 1. 定位行，再二分
     * 2. 暴力搜索完
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int raw = locateRaw(matrix, target);
        if (raw == -1) return false;
        return binarySearch(matrix[raw], target);
    }

    private static boolean binarySearch(int[] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (matrix[middle] == target) return true;
            else if (matrix[middle] < target) low = middle + 1;
            else high = middle - 1;
        }
        return false;
    }

    private static int locateRaw(int[][] matrix, int target) {
        int result = -1;
        for (int i = 0; i < matrix.length; i++) {
            // 注意此处 =，有坑
            if (matrix[i][0] <= target) result = i;
        }
        return result;
    }
}
