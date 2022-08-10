package leetcode.official;

import java.util.HashMap;

public class Question1 {
    /**
     * 最终选择：2
     * <p>
     * 1. 两个循环
     * 2. Hash 寻找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 此处 remove 当前，是因为如果出现重复元素，会重复计算，所以需要先移除，如果移除了之后还有结果
            // 那么直接返回，如果没有结果，再将当前元素加回来，然后循环继续
            map.remove(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};


//        别人的 hash 做法，可以借鉴一下
//        int[] result = new int[2];
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < numbers.length; i++) {
//            if (map.containsKey(target - numbers[i])) {
//                result[1] = i;
//                result[0] = map.get(target - numbers[i]);
//                return result;
//            }
//            map.put(numbers[i], i);
//        }
//        return result;
    }

    /**
     * 方法 1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumTwoLoop(int[] nums, int target) {
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