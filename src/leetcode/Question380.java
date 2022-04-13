package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class Question380 {

    public static class RandomizedSet {
        // 值 Set
        private final HashSet<Integer> values = new HashSet<>();
        // 随机数
        private static final Random random = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (values.contains(val)) {
                return false;
            }
            values.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!values.contains(val)) {
                return false;
            }
            values.remove(val);
            return true;
        }

        /**
         * 此方法是利用 values 的所有现有值作为 ArrayList 的构造函数参数
         * 创建一个新 ArrayList，然后 get 其下标值 idx，idx 此处为 values 的 size 范围内随机生成
         * @return
         */
        public int getRandom() {
            return new ArrayList<>(values).get(random.nextInt(values.size()));
        }
    }
    /**
     * 以下为宫水的解法
     * 时间上要高一点
     */
//    class RandomizedSet {
//        static int[] nums = new int[200010];
//        Random random = new Random();
//        Map<Integer, Integer> map = new HashMap<>();
//        int idx = -1;
//        public boolean insert(int val) {
//            if (map.containsKey(val)) return false;
//            nums[++idx] = val;
//            map.put(val, idx);
//            return true;
//        }
//        public boolean remove(int val) {
//            if (!map.containsKey(val)) return false;
//            int loc = map.remove(val);
//            if (loc != idx) map.put(nums[idx], loc);
//            nums[loc] = nums[idx--];
//            return true;
//        }
//        public int getRandom() {
//            return nums[random.nextInt(idx + 1)];
//        }
//    }
}
