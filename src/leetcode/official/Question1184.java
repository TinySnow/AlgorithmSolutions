package leetcode.official;

public class Question1184 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 边界判断
        if (distance.length < 1 || distance.length > 10000 ||
                start < 0 || start > distance.length ||
                destination < 0 || destination > distance.length) {
            return -1;
        }
        // 如果原地打转直接返回 0
        if (start == destination) {
            return 0;
        }
        // 这里要考虑到目的地和出发地之间的下标大小问题
        // 所以一定要选出小的，否则后续逻辑会出现偏差
        // 当然也可以，如果目的地小于出发地下标值，重新调用这个函数，对调两个参数位置
        // 这里采取设置变量的方法
        int low = Math.min(start, destination);
        int high = Math.max(start, destination);
        int circuity = 0;
        int directly = 0;
        // 将整个数组拆成三部分，前半，中间出发地和目标地直达的部分，后半
        // 前半和后半加起来就是打环的另一条路距离
        for (int i = 0; i < distance.length; i++) {
            if (i >= low && i < high) {
                directly += distance[i];
            } else {
                circuity += distance[i];
            }
        }
        // 返回最小值
        return Math.min(directly, circuity);
    }
}
