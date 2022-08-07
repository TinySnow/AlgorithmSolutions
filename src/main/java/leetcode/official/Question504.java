package leetcode.official;

public class Question504 {
    public static String convertToBase7(int num) {
        // 边界限制
        if (num < -Math.pow(10, 7) || num > Math.pow(10, 7)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        while (true) {
            // 倒插余数
            result.insert(0, num % 7 < 0 ? -num % 7 : num % 7);
            // 观察是否是最后第一位，第一位的商肯定为 0
            if (num / 7 == 0) {
                // 如果有符号，添加符号，跳出循环
                if (num < 0) {
                    result.insert(0, '-');
                }
                break;
            } else {
                // 不是最后一位直接继续
                num /= 7;
            }
        }
        return result.toString();
    }
}
