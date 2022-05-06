package leetcode;

import java.util.ArrayList;

public class Question933 {
    public class RecentCounter {

        private final ArrayList<Integer> record;


        public RecentCounter() {
            this.record = new ArrayList<>();
        }

        public int ping(int t) {
            record.add(t);
            int cnt = 0;
            for (Integer i : record) {
                if (i >= t - 3000 && i <= t) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */

/**
 * 以下为官方题解
 */
//    class RecentCounter {
//        Queue<Integer> queue;
//
//        public RecentCounter() {
//            queue = new ArrayDeque<Integer>();
//        }
//
//        public int ping(int t) {
//            queue.offer(t);
//            while (queue.peek() < t - 3000) {
//                queue.poll();
//            }
//            return queue.size();
//        }
//    }
}
