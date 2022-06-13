package leetcode.official;

public class Question762 {
    public static int countPrimeSetBits(int left, int right) {
        // 边界和逻辑判断
        if (left < 1 || left > right || right > 1000000 || right - left > 10000) {
            return 0;
        }
        // 因为 right 的最大位数为 10^6,转换为二进制最多为 20 位,所以最多有 20 个 1,直接打表硬编码即可
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19};
        // 记录答案个数
        int result = 0;
        // 开始遍历
        for (int i = left; i <= right; i++) {
            // 转换为二进制数
            String s = Integer.toBinaryString(i);
            // 记录 1 的个数
            int count = 0;
            // 遍历二进制位
            for (int j = 0; j < s.length(); j++) {
                // 单个位与 1 进行判断
                // 肯定有更好的做法,但是目前想不出来
                if (Integer.parseInt(s.substring(j, j + 1)) == 1) {
                    count++;
                }
            }
            // 判断 1 的个数是否为质数
            for (int j : prime) {
                // 如果为质数,直接加一然后跳出
                if (count == j) {
                    result++;
                    break;
                }
            }
        }
        return result;
/**
 * 官方题解
 */
//        int ans = 0;
//        for (int x = left; x <= right; ++x) {
//            if (((1 << Integer.bitCount(x)) & 665772) != 0) {
//                ++ans;
//            }
//        }
//        return ans;
    }
}
