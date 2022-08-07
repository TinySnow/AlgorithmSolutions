package leetcode.official;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1051 {
    public int heightChecker(int[] heights) {
        // 边界检查
        if (heights.length > 100){
            return -1;
        }
        // 排序
        List<Integer> list = Arrays.stream(heights).boxed().sorted().collect(Collectors.toList());
        // 一次 循环 对比
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (list.get(i)!=heights[i]) {
                count++;
            }
        }
        return count;

//        int[] t = heights.clone();
//        Arrays.sort(t);
//        int n = heights.length, ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (t[i] != heights[i]) ans++;
//        }
//        return ans;
    }
}
