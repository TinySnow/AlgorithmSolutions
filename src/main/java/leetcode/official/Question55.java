package leetcode.official;

public class Question55 {
    /**
     * 最终选择：贪心
     * 1. 贪心，记录最远能到达的距离，或者倒退回去反向贪心
     * 2. 动态规划
     * 3. 暴力回溯
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true;
        int rightmost = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) return true;
            }
        }
        return false;
    }
}
