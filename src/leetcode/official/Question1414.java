package leetcode.official;

import java.util.ArrayList;

/**
 * UNFINISHED
 *
 * 根据贪心策略进行算法处理
 * 需要证明一定要选取不大于 k 的最大数值
 * 才能使用贪心策略，否则需要涉及动态规划
 */
public class Question1414 {
    public int findMinFibonacciNumbers(int k) {
        // 边界限制
        if (k < 1 || k > Math.pow(10, 9)) {
            return 0;
        }
        // 存放斐波那契数列数值
        ArrayList<Integer> list = new ArrayList<>();
        // 预置 1
        list.add(1);
        // 前项
        int former = 1;
        // 后项
        int latter = 1;
        // 寻找不大于 K 的最大斐波那契数
        while (former + latter <= k) {
            int next = former + latter;
            list.add(next);
            former = latter;
            latter = next;
        }
        int answer = 0;
        // 用贪心依次递减
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            Integer integer = list.get(i);
            if (k >= integer) {
                k -= integer;
                answer++;
            }
        }
        return answer;
    }
}
