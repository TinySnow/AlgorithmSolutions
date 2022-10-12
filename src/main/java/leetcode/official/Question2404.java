package leetcode.official;

import java.util.Arrays;

public class Question2404 {
    /**
     * 最终选择：暴力模拟（因为更快）
     * 1. 暴力模拟
     * 2. 哈希
     *
     * @param nums
     * @return
     */
    public static int mostFrequentEven(int[] nums) {
        if (nums == null) return -1;
        Arrays.sort(nums);
        int previous = nums[0], count = 0, maxCount = Integer.MIN_VALUE, maxValue = -1;
        for (int num : nums) {
            // 排除奇数
            if (num % 2 == 0) {
                // 相同 count++
                if (num == previous) count++;
                // 不相同，计数重置为 1，覆盖前一个数值
                else {
                    count = 1;
                    previous = num;
                }
                // 一旦大于就刷新，否则会出现后面没能赋值的情况
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = previous;
                }
            }
        }
        return maxValue;
    }
}
