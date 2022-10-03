package leetcode.official;

public class Question367 {
    public static boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0 || num == 1) return true;
        int low = 1, high = num;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle == num) return true;
            else if ((long) middle * middle > num) high = middle - 1;
            else low = middle + 1;
        }
        return false;
    }
}
