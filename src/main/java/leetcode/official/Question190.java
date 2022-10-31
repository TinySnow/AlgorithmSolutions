package leetcode.official;

public class Question190 {
    /**
     * 最终选择：位运算分治
     * <p>
     * 1. 逐位取出并 shift 到相应位置
     * 2. 位运算分治，例：
     * 2.1. 12345678
     * 2.2. 5678 1234
     * 2.3. 78 56  34 12
     * 2.4. 8 7 6 5 4 3 2 1
     * 2.5. 87654321
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans |= ((n & 1) << (31 - i));
            n = n >> 1;
        }
        return ans;

//        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
//        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
//        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
//        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
//        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
//
//        return num;
    }
}
