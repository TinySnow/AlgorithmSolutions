package leetcode.official;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question47 {
    /**
     * 1. 递归和 DFS 回溯，有点迷惑
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 为什么必须要这个 used 数组？
        boolean[] used = new boolean[nums.length];
        // 保证重复元素都在一起，所以需要排序
        Arrays.sort(nums);
        recursion(nums, used, list, res);
        return res;
    }

    public void recursion(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // TODO: 此处防重条件有些迷惑
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) continue;
            list.add(nums[i]);
            used[i] = true;
            recursion(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
