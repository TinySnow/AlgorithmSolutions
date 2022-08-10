package leetcode.official;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question239 {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // 双端队列里面存的是下标
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // 如果达到到滑动窗口最大值了，我们就抛去队头元素
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // 如果即将纳入滑动窗口的元素，大于当前的队头元素，我们就抛弃队头
            // 因为此时的队头没有任何用处，已经有最大的元素在了
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // 存入当前最大值的下标值
            q.offer(i);
            // 防止 k-1 个循环里存入意外的值
            // 相当于，如果窗口大小 k 为 3，前两个循环是没有意义的
            // 只是用来筛选最大值，到第三个循环才算作第一个窗口，才能存第一个最大值
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
