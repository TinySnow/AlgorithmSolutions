package leetcode.interview;

public class Question_01_05 {
    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.length()>second.length()) return oneEditAway(second, first);
        int sl = first.length();
        int ll = second.length();
        int i = 0, j = 0, cnt = 0;
        if (Math.abs(sl - ll) > 1) {
            return false;
        } else {
            while (i < sl && j < ll && cnt <= 1) {
                char c1 = first.charAt(i), c2 = second.charAt(j);
                if (c1 == c2) {
                    i++; j++;
                } else {
                    if (sl == ll) {
                        i++;
                    }
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;

    }
}
