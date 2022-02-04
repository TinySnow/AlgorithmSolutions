package leetcode;

import java.util.HashMap;

/**
 * 有更好的算法
 * 此题解空间占用和时间推进都较高
 * 建议使用官方题解
 */
public class Question1725 {
    public int countGoodRectangles(int[][] rectangles) {
        // 边界判断
        if (rectangles.length < 1 || rectangles.length > 1000) {
            return 0;
        }
        // 键为每组出现的边长，值为该最大边长出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            // 找出矩形能切成正方形的那条边（即较小边）
            int min = Math.min(rectangle[0], rectangle[1]);
            if (map.containsKey(min)) {
                // 如果有，则次数加一
                map.replace(min, map.get(min) + 1);
            } else {
                // 没有则推入 map，置次数为一
                map.put(min, 1);
            }
        }
        // 记录最大边长
        int maxLen = 0;
        // 边长数组
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        for (Integer integer : keys) {
            maxLen = Math.max(integer, maxLen);
        }
        // 返回最大边长出现次数
        return map.get(maxLen);
    }
}
