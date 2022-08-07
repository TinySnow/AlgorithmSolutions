package leetcode.official;

public class Question1672 {
    public int maximumWealth(int[][] accounts) {
        // 最大资产
        int maxAsset = 0;
        // 计算每个客户的资产
        for (int[] client : accounts) {
            // 当前客户的资产
            int currentAsset = 0;
            // 计算每个银行资产综合
            for (int eachBankAsset : client) {
                currentAsset += eachBankAsset;
            }
            // 取最大值
            maxAsset = Math.max(currentAsset,maxAsset);
        }
        return maxAsset;
    }
}
