package leetcode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Question1748 {
    public int sumOfUnique(int[] nums) {
        // 边界判断
        if (nums.length < 1 || nums.length > 100) {
            return 0;
        }
        // HashMap 的 Key 为数值，Value 为出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        AtomicInteger result = new AtomicInteger();
        // 判断出现次数，相加得出结果
        map.forEach((k, v) -> {
            if (v <= 1) {
                result.addAndGet(k);
            }
        });
        return result.get();
    }
}
