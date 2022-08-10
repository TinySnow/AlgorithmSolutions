package leetcode.official;

import java.util.ArrayList;

public class Question66 {
    /**
     * 最终选择：2
     * <p>
     * 1. 直接在 digits 数组上进行操作
     * 2. 中转一个 List，然后 List 加出结果之后再 new 一个新数组返回
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length > 100) {
            return digits;
        }
        int carry = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            list.add(digits[i] + carry > 9 ? 0 : digits[i] + carry);
            carry = digits[i] + carry > 9 ? 1 : 0;
        }
        if (carry == 1) list.add(1);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[result.length - i - 1] = list.get(i);
        }
        return result;
    }

    /**
     * 别人的方法 1
     * 我哭了，这么简单
     *
     * @param digits
     * @return
     */
    public static int[] plusOneClean(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
