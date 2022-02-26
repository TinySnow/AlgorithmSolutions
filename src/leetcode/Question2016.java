package leetcode;

public class Question2016 {
    public static int maximumDifference(int[] nums) {
        if (nums.length < 2 || nums.length > 1000) {
            return -1;
        }
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] > result) {
                    result = nums[j] - nums[i];
                }
            }
        }
        return result > 0 ? result : -1;
    }
}
