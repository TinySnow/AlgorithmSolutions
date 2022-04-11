package leetcode;

public class Question357 {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        // 纯数学推导：
        // 合法个数为 T，则 T = T + A
        // T 为之前位数合法数字的个数，A 为恰好该位数的合法数字个数
        // 举例：如果计算 4 位数合法数字个数，
        // 则 T(为 4 位 + 3 位 + 2 位 + 1 位的总个数) = T(3 位 + 2 位 + 1 位的个数) + A(恰好为 4 位数字的个数)
        // 根据乘法原理：
        // 合法数字个数为 C(9, 1) * A(9,n - 1)
        // C(9, 1)意为，最高位从 1 到 9 中任选一个
        // A(9, n - 1)意为，其他位，从 0 到 9 任选 n - 1 个数字出来任意组合(0 - 9 为 10 个数字，但最高位选了 1 个数字走，所以还是剩下 9 个数字)
        // n - 1 中 n 为需要求的位数，
        // 例如要求 3 位数及其以前的合法数字个数，则选一个百位，然后再选 3 - 1 = 2 个数字放在十位和个位两个位置上任意组合
        switch (n) {
            case 0:
                result = 1;
                break;
            case 1:
                result = 9 + 1;
                break;
            case 2:
                result = 9 * 9 + 9 + 1;
                break;
            case 3:
                result = 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
            case 4:
                result = 9 * 9 * 8 * 7 + 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
            case 5:
                result = 9 * 9 * 8 * 7 * 6 + 9 * 9 * 8 * 7 + 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
            case 6:
                result = 9 * 9 * 8 * 7 * 6 * 5 + 9 * 9 * 8 * 7 * 6 + 9 * 9 * 8 * 7 + 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
            case 7:
                result = 9 * 9 * 8 * 7 * 6 * 5 * 4 + 9 * 9 * 8 * 7 * 6 * 5 + 9 * 9 * 8 * 7 * 6 + 9 * 9 * 8 * 7 + 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
            case 8:
                result = 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 + 9 * 9 * 8 * 7 * 6 * 5 * 4 + 9 * 9 * 8 * 7 * 6 * 5 + 9 * 9 * 8 * 7 * 6 + 9 * 9 * 8 * 7 + 9 * 9 * 8 + 9 * 9 + 9 + 1;
                break;
        }
        return result;


/**
 * 以下为宫水的解法，看起来简洁一点。
 */
//        if (n == 0) return 1;
//        int ans = 10;
//        for (int i = 2, last = 9; i <= n; i++) {
//            int cur = last * (10 - i + 1);
//            ans += cur;
//            last = cur;
//        }
//        return ans;
    }
}
