package leetcode.school;

import java.util.Arrays;

public class OptimalImageCompressionQuestion {
    public static int optimalBits(int[] dots, int[] traces) {
        int[] dp = new int[dots.length + 1];
        int cost;
        dp[0] = 0;
        for (int i = 1; i <= dots.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(i, 256); j++) {
                cost = dp[i - j] + j * (minBits(max(dots, i - j + 1, i))) + 11;
                if (cost < dp[i]) {
                    dp[i] = cost;
                    traces[i] = j;
                }
            }
        }
        return dp[dots.length];
    }

    public static void print(int[] traces, int length) {
        length -= traces[length];
        if (length <= 0) {
            return;
        }
        print(traces, length);
        System.out.print(length + " ");
    }

    private static int max(int[] dots, int start, int end) {
        int[] copy = Arrays.copyOfRange(dots, start - 1, end);
        Arrays.sort(copy);
        return copy[copy.length - 1];
    }

    private static int minBits(int number) {
        int bits = 0;
        for (int i = 1; i <= 8; i++) {
            if (Math.pow(2, i - 1) - 1 <= number && Math.pow(2, i) - 1 >= number) {
                bits = i;
                break;
            }
        }
        return bits;
    }
//    public static void main(String[] args) {
//        int[] dots = new int[]{10, 12, 15, 255, 1, 2, 1, 1, 2, 2, 1, 1};
//        int[] traces = new int[dots.length + 1];
//        System.out.println("最少二进制位：" + OptimalImageCompressionQuestion.optimalBits(dots, traces));
//        System.out.print("切分位置：");
//        OptimalImageCompressionQuestion.print(traces, dots.length);
//    }

}
