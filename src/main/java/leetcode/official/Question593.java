package leetcode.official;

import java.util.Arrays;
import java.util.HashSet;

public class Question593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 数据合法性检验
        if (p1.length != 2 || p2.length != 2 || p3.length != 2 || p4.length != 2 ||
                Arrays.equals(p1, p2) || Arrays.equals(p1, p3) || Arrays.equals(p1, p4) ||
                Arrays.equals(p2, p3) || Arrays.equals(p2, p4) || Arrays.equals(p3, p4)) {
            return false;
        }
        // 保存距离结果
        HashSet<Double> set = new HashSet<>();
        // 每两个之间算距离，一定是边或者对角线
        distance(p1, p2, set);
        distance(p1, p3, set);
        distance(p1, p4, set);
        distance(p2, p3, set);
        distance(p2, p4, set);
        distance(p3, p4, set);
        return set.size() <= 2;
    }

    private void distance(int[] origin, int[] destination, HashSet<Double> set) {
        set.add(Math.pow(origin[0] - destination[0], 2) + Math.pow(origin[1] - destination[1], 2));
    }
}
