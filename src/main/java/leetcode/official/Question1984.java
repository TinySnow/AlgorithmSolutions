package leetcode.official;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * UNFINISHED
 * 想复杂了
 */
public class Question1984 {
    public static int minimumDifference(int[] nums, int k) {
        if (nums.length <= 1 || nums.length > 1000 || k <= 1 || k > 1000 || k > nums.length) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        if (list.size() == k) {
            return list.get(list.size() - 1) - list.get(0);
        }
        int minIndex = 0;
        int maxIndex = 1;
        int result = list.get(maxIndex) - list.get(minIndex);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (result > list.get(j) - list.get(i)) {
                    result = list.get(j) - list.get(i);
                    minIndex = i;
                    maxIndex = j;
                }
            }
        }
        int totalCount = 2;
        while (totalCount < k) {
            int formerIndex = minIndex - 1;
            Integer former = formerIndex >= 0 ? list.get(formerIndex) : null;
            int latterIndex = maxIndex + 1;
            Integer latter = latterIndex <= list.size() - 1 ? list.get(latterIndex) : null;
            if (former != null && latter != null) {
                if (list.get(minIndex) - former < latter - list.get(maxIndex)) {
                    minIndex = formerIndex;
                } else {
                    maxIndex = latterIndex;
                }
            } else if (former == null) {
                maxIndex = latterIndex;
            } else {
                minIndex = formerIndex;
            }
            result = list.get(maxIndex) - list.get(minIndex);
            totalCount++;
        }
        return result;

//        /**
//         * 以下为官方题解
//         */
//        int n = nums.length;
//        Arrays.sort(nums);
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i + k - 1 < n; ++i) {
//            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
//        }
//        return ans;
    }
}
