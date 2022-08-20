package leetcode.official;

import java.util.Arrays;

public class Question169 {
    /**
     * 最终选择：2
     * <p>
     * 1. 哈希。HashMap 值和次数扔进去，最后比较次数（如果同时维护一个次数最大值，则可以不用遍历 HashMap）
     * 2. 取中位数。因为众数的次数一定超过数组的一半，所以对数组进行排序后，一定能在中位数找到众数，否则不满足题设条件
     * 3. 暴力遍历。先遍历一遍找出各个元素，然后遍历第二遍统计次数
     * 4. 分治。分成左右数组两半，分别找众数，然后再从这两个候选数中决出真正的众数。如果 spilt 成一个元素，直接返回。
     * 5. 投票法。这个没看懂，好魔性。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
