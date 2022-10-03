package leetcode.official;

public class Question69 {
    /**
     * 最终选择：1
     * 1. 二分查找
     * 2. 牛顿迭代法
     * <p>
     * 查了很久 bug，最后发现是 if 判断时里面没有强转类型
     * 括号里面也要强转类型才行
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int low = 1, high = x;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if ((long) middle * middle == x) return middle;
            else if ((long) middle * middle > x) high = middle - 1;
            else low = middle + 1;
        }
        return high;
    }
}
