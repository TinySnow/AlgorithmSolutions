package leetcode.official;

import java.util.Arrays;

public class Question189 {
    /**
     * 很简单，不写注释了
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        // 边界判断
        if (k == 0 || nums == null || nums.length > 100000) {
            return ;
        }
        // 将 k 映射到数组长度内，防止出现长度为 1 的数组，右移 2 次这种会使下面 indexOutOfBounds 的情况
        k %= nums.length;
        int[] copy = Arrays.copyOf(nums, nums.length);
        System.arraycopy(copy, copy.length - k, nums, 0, k);
        System.arraycopy(copy, 0, nums, k, copy.length - k);
        return ;
    }
    public static int[] rotateTest(int[] nums, int k) {
        // 边界判断
        if (k == 0 || nums == null || nums.length > 100000) {
            return null;
        }
        // 将 k 映射到数组长度内，防止出现长度为 1 的数组，右移 2 次这种会使下面 indexOutOfBounds 的情况
        k %= nums.length;
        int[] copy = Arrays.copyOf(nums, nums.length);
        System.arraycopy(copy, copy.length - k, nums, 0, k);
        System.arraycopy(copy, 0, nums, k, copy.length - k);
        return nums;
    }
}
