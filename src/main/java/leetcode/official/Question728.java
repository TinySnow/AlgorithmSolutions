package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        // 边界判断
        if (left < 1 || right > 10000 || left > right) {
            return null;
        }
        // 结果集
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            // 个位数都符合题意
            // 然后根据数据位数进行判断
            if (i < 10) {
                result.add(i);
            } else if (i < 100) {
                int single = i % 10;
                int ten = i / 10;
                if (single != 0 && i % single == 0 && i % ten == 0) {
                    result.add(i);
                }
            } else if (i < 1000) {
                int single = i % 10;
                int ten = i / 10 % 10;
                int hundred = i / 100;
                if (single != 0 && ten != 0 && i % single == 0 && i % ten == 0 && i % hundred == 0) {
                    result.add(i);
                }
            } else if (i < 10000) {
                int single = i % 10;
                int ten = i / 10 % 10;
                int hundred = i / 100 % 10;
                int thousand = i / 1000;
                if (single != 0 && ten != 0 && hundred != 0 && i % single == 0 && i % ten == 0 && i % hundred == 0 && i % thousand == 0) {
                    result.add(i);
                }
            }
        }
        return result;
/**
 * 下列为宫水三叶的解法，根据题意模拟，要聪明得多，建议学习。
 */
//        List<Integer> ans = new ArrayList<>();
//        out:for (int i = left; i <= right; i++) {
//            int cur = i;
//            while (cur != 0) {
//                int t = cur % 10;
//                if (t == 0 || i % t != 0) continue out;
//                cur /= 10;
//            }
//            ans.add(i);
//        }
//        return ans;
    }
}
