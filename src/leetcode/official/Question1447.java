package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question1447 {
    public static List<String> simplifiedFractions(int n) {
        // 边界判定
        if (n <= 1 || n > 100) {
            return new ArrayList<>();
        }
        // 提前有序枚举好所有的素数
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        // 结果 List
        ArrayList<String> result = new ArrayList<>();
        // 素数下标值，因为 100 以内的素数只有 25 个，所以最大的下标值为 24
        int primeNumbersIndex = 0;
        // 固定分母
        for (int denominator = 2; denominator <= n; denominator++) {
            // 如果分母是素数，则不用进入公因式判断，直接枚举所有小于分母的分子，加入结果 List
            if (denominator == primeNumbers[primeNumbersIndex]) {
                for (int numerator = 1; numerator < denominator; numerator++) {
                    result.add(numerator + "/" + denominator);
                }
                // 用完了这个素数，把下标值往前推一个，最大值为 24，所以到了 24 就不要往上加了，否则直接 IndexOutOfBounds
                if (primeNumbersIndex < 24) {
                    primeNumbersIndex++;
                }
            } else {
                // 开始遍历小于分母的数
                for (int numerator = 1; numerator < denominator; numerator++) {
                    // 如果找到了公因子，会返回 true，所以没有公因子应该是 false
                    // 故，我们取非，进入这个 if 推入结果 List
                    if (!findCommonDivisor(numerator, denominator)) {
                        result.add(numerator + "/" + denominator);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 该函数寻找分子和分母的公因子
     * @param numerator 分子
     * @param denominator 分母
     * @return 如果有公因子，则返回 true，否则返回 false
     */
    private static boolean findCommonDivisor(int numerator, int denominator) {
        // 从 2 开始做除数，注意这个边界条件
        for (int divisor = 2; divisor <= numerator; divisor++) {
            if (numerator % divisor == 0 && denominator % divisor == 0) {
                return true;
            }
        }
        return false;
    }
}
