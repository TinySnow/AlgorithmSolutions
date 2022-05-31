package leetcode.school;

/*
 * 刘廷利的代码
 * 201902099
 *
 * 用回溯法实现 0 - 1 背包问题。
 * 在回溯开始之前，首先对于背包中的物品按照单位重量价值进行排序，方便于后面右子树的剪枝操作。
 * 在初始化物品的重量和价值时，已经按照单位重量的价值排好了序。
 * */
public class BackpackBackTrackSolution {
    //物品数量
    public int n = 10;
    //背包容量
    public int capacity = 50;
    //物品重量数组
    static double[] weight = {4, 8, 9, 3, 11, 5, 7, 12, 10, 6};
    //物品价值数组
    static double[] value = {10, 9, 8, 2, 7, 3, 4, 6, 5, 2};


    //最大价值
    public int maxValue = 0;
    //当前最大价值
    public int currentValue;
    //当前重量
    public int currentWeight;
    // 装入方法数组
    public int[] way = new int[n];
    //最佳装入方法数组
    public int[] bestWay = new int[n];

    /*
     * 回溯算法设计
     * */
    public void backTrack(int t) {
        // 已经搜索到根节点
        if (t > n - 1) {
            if (currentValue > maxValue) {
                maxValue = currentValue;
                if (n >= 0) System.arraycopy(way, 0, bestWay, 0, n);
            }
            return;
        }
        // 搜索左边节点
        if (currentWeight + weight[t] <= capacity) {
            currentWeight += weight[t];
            currentValue += value[t];
            way[t] = 1;
            //回溯
            backTrack(t + 1);
            currentWeight -= weight[t];
            currentValue -= value[t];
            way[t] = 0;
        }
        // 不装入这个物品，直接搜索右边的节点
        if (bound(t + 1) >= maxValue) {
            backTrack(t + 1);
        }
    }

    // 用于计算剩余物品的最高价值上界
    public double bound(int k) {
        double maxLeft = currentValue;
        int leftWeight = capacity - currentWeight;
        // 尽力依照单位重量价值次序装剩余的物品
        while (k <= n - 1 && leftWeight > weight[k]) {
            leftWeight -= weight[k];
            maxLeft += value[k];
            k++;
        }
        // 不能装时，用下一个物品的单位重量价值折算到剩余空间。
        if (k <= n - 1) {
            maxLeft += value[k] / weight[k] * leftWeight;
        }
        return maxLeft;
    }

//    public static void main(String[] args) {
//        BackpackBackTrackSolution solution = new BackpackBackTrackSolution();
//        solution.backTrack(0);
//        System.out.println("该背包能够取到的最大价值为:" + solution.maxValue);
//        System.out.println("当前背包的重量为:" + solution.capacity);
//        System.out.println("物品的取出方法为取出的方法为:");
//        for (int i : solution.bestWay)
//            System.out.print(i + "  ");
//    }
}
