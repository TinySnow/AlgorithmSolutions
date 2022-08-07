package leetcode.official;

public class Question283 {
    /**
     * 最终选择：方法 3
     *
     * 1. 统计 0 的个数，所有非零元素往前移
     * 2. 开新数组
     * 3. 在数组中进行 index 操作
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 边界判断
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0, last = -1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[++last] = nums[i];
                if (i != last) {
                    nums[i] = 0;
                }
            }
        }
    }
}
