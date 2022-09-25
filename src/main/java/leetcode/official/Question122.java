package leetcode.official;

public class Question122 {
    /**
     * 贪心，选取当前部分的最高价和最低价进行计算
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        // 当前是否持有股票
        boolean have = false;
        // 总利润
        int profit = 0;
        // 当前能找到的最低价和最高价的天数
        // 注意，此处的最低价和最高价是阶段性的最低价和最高价，不是整个数组的
        int lowest = 0, highest = 0;
        // 遍历整个股票数组
        //
        // 如果没有股票：将当前股票与历史股票的最低价相比，
        // 当前股票比其还要低（降序），说明历史股票不该买，更新历史股票最低价为当前股票
        // 当前股票比其要高（升序），说明历史股票的最低价已经是该阶段的真正最低价了，该买，而在什么时候抛售交给有股票的情况
        //
        // 如果有股票：将当前股票与历史股票的最高价相比，
        // 当前股票比其要低（降序），说明历史股票的那一天就该抛售，计算利润，然后重置最低价和最高价
        // 当前股票比其要高（升序），说明还不是抛售的最佳时机，将最高价替换掉，然后移动到下一个
        for (int i = 1; i < prices.length; i++) {
            if (have) {
                if (prices[i] <= prices[highest]) {
                    profit += prices[highest] - prices[lowest];
                    lowest = i;
                    have = false;
                }
                highest = i;
            } else {
                if (prices[i] > prices[lowest]) {
                    have = true;
                    highest = i;
                } else {
                    lowest = i;
                }
            }
        }
        // 有可能股票数组后部分一直升序
        // 会发生买了股票后遍历完数组也没卖的情况，所以此处需要检查一下是否是这种情况
        // 如果是，用最高价（数组最后一个）减去最低价
        if (have) profit += prices[prices.length-1] - prices[lowest];
        return profit;

        // 看了这个题解发现自己是憨批

//        int profit = 0;
//        for (int i = 1; i < prices.length; i++)
//            profit += Math.max(0, prices[i] - prices[i - 1]);
//        return profit;
    }
}
