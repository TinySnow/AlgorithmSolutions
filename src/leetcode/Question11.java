package leetcode;

public class Question11 {
    /**
     * 双指针，每次移动最差的那一边
     * @param height 高度数组
     * @return
     */
    public int maxArea(int[] height) {
        // 边界判断
        if (height == null || height.length <= 1) {
            return -1;
        }
        int head = 0, tail = height.length - 1, max = 0;
        // 开始移动，每次移动短一些的那一边，虽然会差，但是可能会有更好的结果
        while (head < tail) {
            int shorter = height[head] < height[tail] ? height[head++] : height[tail--];
            max = Math.max(max, (tail - head + 1) * shorter);
        }
        return max;
    }
}
