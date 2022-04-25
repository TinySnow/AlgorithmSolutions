package leetcode;

public class Question868 {
    public static int binaryGap(int n) {
        // 边界判断
        if (n < 1 || n > Math.pow(10, 9)) {
            return 0;
        }
        // 转换二进制 String
        String s = Integer.toBinaryString(n);
        // 最大间距结果
        int result = 0;
        // 计数 1 的个数
        int counter = 0;
        // 相邻 1 之间的距离
        int distance = 0;
        for (int i = 0; i < s.length(); i++) {
            // 取出字符判断
            char c = s.charAt(i);
            // 如果为 0，则距离加一
            if (c == '0') {
                distance++;
            }
            // 如果为 1，则个数加一
            // 并且此时 1 的个数为偶数，则计算最大距离
            // 然后将距离计数置为空，计数 1 的变量置为 1
            else {
                counter++;
                if (counter % 2 == 0) {
                    result = Math.max(result, ++distance);
                    distance = 0;
                    counter = 1;
                }
            }
        }
        return result;
/**
 * 宫水的解法
 * 效率高一些
 */
//        int ans = 0;
//        for (int i = 31, j = -1; i >= 0; i--) {
//            if (((n >> i) & 1) == 1) {
//                if (j != -1) ans = Math.max(ans, j - i);
//                j = i;
//            }
//        }
//        return ans;
    }
}
