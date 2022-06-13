package leetcode.official;

public class Question2006 {
    public int countKDifference(int[] nums, int k) {
        // 边界判定
        if (nums.length <= 1 || nums.length > 200 || k < 1 || k > 99) {
            return 0;
        }
        int result = 0;
        // 暴力求解
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
