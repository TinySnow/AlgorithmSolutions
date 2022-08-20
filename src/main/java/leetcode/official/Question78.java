package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question78 {
    /**
     * 最终选择：1
     * <p>
     * 1. 递归，深度优先，状态二叉树
     *    对于数组中的每个元素，都有两种可能：选或者不选，构成两种不同的状态和子集，
     *    将其一直传下去，直到数组长度和待选元素的下标相等，加入结果集
     *    注意：因为每次在参数中改变了元素的个数，所以需要在递归模板最后重置为原来的样子
     * 2. 递归，插入序列回溯
     *    对于每加入一个元素，我们都将其加入 <之前存在过的所有子集>，然后将此集合和 <之前存在过的所有子集> 重新拼接
     *    构成新的集合，然后再次递归，直到插入的元素是最后一个元素，退出（所以此方法也可以使用迭代）
     * 3. 暴力
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void dfs(int[] nums, int idx, List<Integer> list, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 不选择此元素，直接往下传
        dfs(nums, idx + 1, list, result);
        // 选择此元素，加入 list，然后往下传
        list.add(nums[idx]);
        dfs(nums, idx + 1, list, result);
        // 最后重置 list 的状态
        list.remove(list.size() - 1);
    }
}
