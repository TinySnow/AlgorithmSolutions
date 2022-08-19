package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question46 {
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 1. DFS 递归，没什么好讲的，开始想复杂了
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        recursion(nums, new ArrayList<>());
        return result;
    }

    /**
     * 注意此处递归终止条件
     * @param ints
     * @param path
     */
    private void recursion(int[] ints, List<Integer> path) {
        if (path.size() == ints.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : ints) {
            // 跳过重复数字
            if (path.contains(i)) continue;
            // 进入下一层
            path.add(i);
            recursion(ints, path);
            // DFS 回溯
            path.remove(path.size() - 1);
        }
    }
}
