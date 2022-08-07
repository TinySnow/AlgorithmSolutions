package leetcode.official;

public class Question11 {
    /**
     * 最终选择：方法 2
     *
     * 1. 暴力枚举每个桶，测量体积，选取最大的容器
     * 2. 选取开始和末尾，往里贪心收敛，宽度一定会更窄，但高度可能会更高，所以面积可能会更大
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
