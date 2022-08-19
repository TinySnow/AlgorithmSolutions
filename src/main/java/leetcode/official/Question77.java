package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question77 {
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 1. 递归，k 个数字组合肯定由 k - 1 得来，可以进行递归
     * 2. 可以进行迭代，应该？
     * <p>
     * 每进入下一层，首先判断还有没有多余的位置可以添加数字
     * 如果有，则多添加一个数字进入 list，没有则直接加入 result 然后返回
     * 然后再进入下一层递归
     * 递归完毕之后，我们认为：在该数字被添加后的所有 k 个组合，都已经被找到
     * 所以下一步，撤回这个数字，添加新的数字（用新数字替代该数字，然后找组合）
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        recursion(n, k, 1, new ArrayList<>());
        return result;
    }

    private void recursion(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            // 注意这里要 new 一个新的，否则底层还是指向原来的 list，这样的话最后撤销完毕回到顶层会为空
            result.add(new ArrayList<>(list));
            return;
        }
        // TODO: 注意这里的条件
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            recursion(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
