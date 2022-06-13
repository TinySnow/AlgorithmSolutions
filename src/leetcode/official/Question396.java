package leetcode.official;

/**
 * UNFINISHED
 * 思路应该是没错的
 * 但不知道哪儿出问题了
 */
public class Question396 {
    public static int maxRotateFunction(int[] nums) {
        // 重命名常量
        int n = nums.length;
        // 边界判断
        if (n < 1 || n > 100000) {
            return 0;
        }
        // 构造一个两倍长数组，便于计算
        int[] doubleArray = new int[n * 2];
        // 填充两倍长数组
        System.arraycopy(nums, 0, doubleArray, 0, n);
        System.arraycopy(nums, 0, doubleArray, n, n);
        // 最终结果
        int result = 0;
        // 顺时针旋转的偏移量，用于循环计算
        // 注意：
        // 为使下面 while 循环成立，初始值置为 1，但实际需要从 0 开始
        // 所以需要将 offset - 1 作为整体使用
        int offset = 1;
        // 进行暴力模拟
        while (offset <= n) {
            int calculateResult = 0;
            int coefficient = n - 1;
            for (int i = doubleArray.length - 1 - (offset - 1); i >= n - (offset - 1); i--) {
                calculateResult += doubleArray[i] * coefficient--;
            }
            result = Math.max(result, calculateResult);
            offset++;
            System.out.println(calculateResult);
        }
        return result;
        /**
         * 以下是宫水的解法
         * 黑魔法
         */
//        int n = nums.length;
//        int[] sum = new int[n * 2 + 10];
//        for (int i = 1; i <= 2 * n; i++) sum[i] = sum[i - 1] + nums[(i - 1) % n];
//        int ans = 0;
//        for (int i = 1; i <= n; i++) ans += nums[i - 1] * (i - 1);
//        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
//            cur += nums[(i - 1) % n] * (n - 1);
//            cur -= sum[i - 1] - sum[i - n];
//            if (cur > ans) ans = cur;
//        }
//        return ans;
    }
}
