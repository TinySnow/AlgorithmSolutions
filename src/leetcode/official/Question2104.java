package leetcode.official;

public class Question2104 {
    public static long subArrayRanges(int[] nums) {
        // 边界确定
        if (nums.length <= 1 || nums.length > 1000) {
            return 0;
        }
        // 返回结果
        long result = 0;
        // 暴力遍历，同时维护区间最大值和最小值
        for (int i = 0; i < nums.length; i++) {
            long min = nums[i];
            long max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                // 结果相加
                result += (max - min);
            }
        }
        return result;
    }
}
