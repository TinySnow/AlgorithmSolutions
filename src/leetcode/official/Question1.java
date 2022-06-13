package leetcode.official;

public class Question1 {
    public static int[] twoSum(int[] nums, int target) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 从前一下标值加一后的位置开始遍历
            // 没有必要从头开始遍历
            for (int j = i + 1; j < nums.length; j++) {
                // 符合条件即返回
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        // 否则返回空
        return null;
    }
}