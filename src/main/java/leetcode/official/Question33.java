package leetcode.official;

public class Question33 {
    /**
     * 1. 分成两半二分：找到旋转的下标值，然后左右取最大值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        int idx = findRotatedIdx(nums);
        int result = -1;
        result = Math.max(binarySearch(0, idx, nums, target), binarySearch(idx + 1, nums.length - 1, nums, target));
        return result;
    }

    private static int binarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
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
