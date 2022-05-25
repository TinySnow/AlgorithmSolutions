package leetcode.school;

public class BackpackQuestion {
    /**
     * 0-1背包问题
     *
     * @param capacity 背包容量
     * @param types    物品种类
     * @param weight   物品重量
     * @param value    物品价值
     * @return
     */
    public static String ZeroOnePack(int capacity, int types, int[] weight, int[] value) {

        int[][] dp = new int[types + 1][capacity + 1];
        // 为了便于理解，将 dp[i][0] 和 dp[0][j] 均置为 0，从 1 开始计算
        for (int i = 1; i < types + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                // 如果第 i 件物品的重量大于背包容量 j，则不装入背包
                // 由于 weight 和 value 数组下标都是从 0 开始
                // 故注意第 i 个物品的重量为 weight[i - 1]，价值为 value[i - 1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        // 则容量为 capacity 的背包能够装入物品的最大值为
        int maxValue = dp[types][capacity];
        // 逆推找出装入背包的所有商品的编号
        int j = capacity;
        StringBuilder numStr = new StringBuilder();
        numStr.append("第 ");
        for (int i = types; i > 0; i--) {
            //若果 dp[i][j] > dp[i - 1][j]，这说明第 i 件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr.append(i).append(" ");
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        numStr.append("件装入背包");
        return numStr.toString();
    }

    public static void BackPack_Greedy(int capacity, int types, int[] weight, int[] value) {
        // 数据有误
        if (weight.length != value.length) {
            return;
        }
        // 价值密度数组
        double[] density = new double[weight.length];
        // 索引数组
        int[] index = new int[weight.length];
        int maxValue = 0, maxWeight = capacity;
        // 计算价值密度
        for (int i = 0; i < weight.length; i++) {
            density[i] = (double) value[i] / weight[i];
            index[i] = i;
        }
        // 冒泡排序
        for (int i = 0; i < density.length - 1; i++) {
            for (int j = 0; j < density.length - 1 - i; j++) {
                if (density[j] < density[j + 1]) {
                    double temp = density[j];
                    density[j] = density[j + 1];
                    density[j + 1] = temp;

                    // index 一起交换
                    int temp1 = index[j];
                    index[j] = index[j + 1];
                    index[j + 1] = temp1;
                }
            }
        }
        // 计算最优解
        System.out.print("贪心算法：第 ");
        for (int j : index) {
            if (weight[j] <= capacity) {
                maxWeight += weight[j];
                maxValue += value[j];
                capacity -= weight[j];
                System.out.print(j + 1 + " ");
            }
        }
        System.out.println("件装入背包");

        System.out.println("总重量：" + maxWeight);
        System.out.println("总价值：" + maxValue);
    }
}
