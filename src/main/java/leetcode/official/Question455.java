package leetcode.official;

import java.util.Arrays;

public class Question455 {
    /**
     * 直接贪心即可，贪心效率高，是最优解
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return -1;
        Arrays.sort(g);
        Arrays.sort(s);
        int gf = 0, sf = 0, cnt = 0;
        // 开始遍历两个数组
        while (gf < g.length && sf < s.length) {
            // 如果胃口大，饼干小，那么胃口不变，饼干需要往下挪一个位置再次进行比较
            // 如果胃口小，饼干大，那么胃口和饼干都要往下挪，因为饼干被吃了
            // 而因为有序排列，所以贪心递推是不会出现特别大的饼干分给一个特别小的胃口，然后后面胃口没得分的情况的
            // 综上所述：饼干数组一定会往后移，胃口数组移动与否看情况
            if (s[sf++] >= g[gf]) {
                cnt++;
                gf++;
            }
        }
        return cnt;
    }
}
