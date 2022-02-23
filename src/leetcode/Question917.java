package leetcode;

/**
 * UNFINISHED
 * 思维混乱
 */
public class Question917 {
    public static String reverseOnlyLetters(String s) {
        if (s.length() < 1 || s.length() > 100) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int sFront = 0;
        int sRare = s.length() - 1;
        // 前后指针同时往对面走
        while (sRare != 0 || sFront != s.length() - 1) {
            char c1 = s.charAt(sFront);
            char c2 = s.charAt(sRare);
            if (sRare == 0 && sFront != s.length() - 1) {
                if (!isAlphabet(c1)) {
                    builder.append(c1);
                }
                sFront++;
            } else if (sFront == s.length() - 1 && sRare != 0) {
                if (isAlphabet(c2)) {
                    builder.append(c2);
                }
                sRare--;
            } else {
                if (!isAlphabet(c1)) {
                    // 如果前指针遇到非字母字符，直接追加进入 builder
                    // 同时前指针往前移动一位，后指针保持不变
                    builder.append(c1);
                    sFront++;
                    // 此处说明前指针遇到了字母字符
                } else {
                    // 如果后指针遇到字母字符，追加进入 builder
                    // 然后两个指针同时移动，前指针向后，后指针向前
                    if (isAlphabet(c2)) {
                        builder.append(c2);
                        sFront++;
                    }
                    // 此处说明遇到了非字母字符，前指针不变，后指针往前走一位
                    sRare--;
                }
            }
        }
        return builder.toString();
    }

    private static boolean isAlphabet(char c2) {
        return (c2 >= 65 && c2 <= 90) || (c2 >= 97 && c2 <= 122);
    }
}
