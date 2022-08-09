package leetcode.official;

public class Question26 {
    /**
     * 不写注释了，很简单
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2 || nums.length > 30000) {
            return nums.length;
        }
        int noDuplicateIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[noDuplicateIndex++] = nums[i];
            }
        }
        return noDuplicateIndex;
    }
}
