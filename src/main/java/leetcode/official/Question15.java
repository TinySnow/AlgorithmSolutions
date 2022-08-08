package leetcode.official;

import java.util.*;

public class Question15 {
    /**
     * 最终选择：方法 3
     * 此处解法为方法 3
     * <p>
     * 1. 暴力求解，三层循环
     * 2. hash 优化 1，优化到两层循环
     * 3. 双指针
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 边界判断
        if (nums.length <3 || nums.length>3000){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        // 固定一个指针，注意这个 -2，相当于最终只循环到数组的倒数第三个就跳出（nums.length -2 是倒数第二个）
        // 倒数第三个的时候，最后还剩两个，就是 low 和 high
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过相同的 element
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                // 固定指针都大于零了，说明三个数都大于零了，相加不可能为零，直接结束循环
                if (nums[i] > 0) {
                    break;
                }
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        // 去重
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    // 相加小于之和的话，说明左边的负数小，移动左边
                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    /**
     * 1. 暴力求解
     * 超时，并且可能有重复结果
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumForce(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        ArrayList<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 2. Hash 法
     * 优化，但是仍然有可能有重复结果
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumHash(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> ints = new HashSet<>(nums.length);
        for (int i : nums) {
            ints.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (ints.contains(-(nums[i] + nums[j]))) {
                    ArrayList<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-nums[i] - nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
