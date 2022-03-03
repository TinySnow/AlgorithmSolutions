package leetcode;

public class Question258 {
    public static int addDigits(int num) {
        // 转换为 String
        String s = String.valueOf(num);
        int result = 0;
        // 因为题目中保证了 num 为正整数，而各位相加肯定不为零
        // 各位相加能为零的只有零本身，所以如果遇到零，直接返回
        if (num == 0) {
            return 0;
        }
        while (result <= 0 || result > 10) {
            // 各位相加，暴力模拟
            for (int i = 0; i < s.length(); i++) {
                result += Integer.parseInt(s.substring(i, i + 1));
            }
            // 结果不为一位，重新赋值 s，将 result 置为 0，直到结果为一位
            if (result >= 10) {
                s = String.valueOf(result);
                result = 0;
            }
        }
        return result;
    }
}
