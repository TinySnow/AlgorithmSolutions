package leetcode.official;

public class Question153 {
    /**
     * 最终选择：1
     * 注意：此题用了跟第 33 题完全一样的函数，用于找出半有序数组中，开始无序位置时，左边的下标值
     * 1. 找到下标值，二分，比 33 题简单
     * 2. 暴力遍历完毕
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return nums[0];
        int idx = findRotatedIdx(nums);
        return Math.min(nums[idx], nums[idx + 1]);
    }

    private static int findRotatedIdx(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (high - low > 1) {
            int middle = low + (high - low) / 2;
            if (nums[middle] > nums[low] & nums[low] > nums[high]) low = middle;
            else if (nums[middle] < nums[low] & nums[low] > nums[high]) high = middle;
            else high--;
        }
        return low;
    }
}
