package leetcode.school;

public class ActivityArrangeQuestion {
    /**
     * 活动安排贪心算法
     * @param s 开始时间表
     * @param f 结束时间表，注意：传入时需要非严格递增排序
     * @param a 是否选中的 bool 数组
     * @return 选中活动的个数
     */
    public static int greedy(int[] s, int[] f, boolean[] a) {
        // 数据有误
        if (s.length != f.length || s.length == 0 || a.length == 0) {
            return -1;
        }
        // 总是选中第一个
        a[0] = true;
        // 前一个活动的下标值
        int j = 0;
        // 总活动个数
        int count = 1;
        // 循环变量 i 为下一个活动的下标值
        for (int i = 1; i <= s.length - 1; i++) {
            if (s[i] >= f[j]) {
                a[i] = true;
                j = i;
                count++;
            } else {
                a[i] = false;
            }
        }
        return count;
    }
}
