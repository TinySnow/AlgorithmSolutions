package leetcode;

public class Question762 {
    public static int countPrimeSetBits(int left, int right) {
        if (left < 1 || left > right || right > 1000000 || right - left > 10000) {
            return 0;
        }
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19};
        int result = 0;
        for (int i = left; i <= right; i++) {
            String s = Integer.toBinaryString(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (Integer.parseInt(s.substring(j, j + 1)) == 1) {
                    count++;
                }
            }
            for (int j : prime) {
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
