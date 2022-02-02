package leetcode;

public class Question1342 {
    public static int numberOfSteps(int num) {
        // 边界确定
        if (num < 0 || num >= 1000000) {
            return -1;
        }
        // 判断奇偶
        boolean isOdd = num % 2 == 1;
        // 计数变量
        int count = 0;
        // 直至为零一直循环
        while (num != 0) {
            if (isOdd) {
                // 奇数减一，必为偶数，赋值 false
                num -= 1;
                isOdd = false;
            } else {
                // 偶数除二，判断奇偶
                num /= 2;
                isOdd = num % 2 == 1;
            }
            // 步数加一
            count++;
        }
        // 返回结果
        return count;
    }
}
