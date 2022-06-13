package leetcode.official;

public class Question806 {
    public static int[] numberOfLines(int[] widths, String s) {
        // 边界判断
        if (s.length() < 1 || s.length() > 1000 || widths.length != 26) {
            return new int[]{0, 0};
        }
        // 初始为 1 行
        int rowCnt = 1;
        // 目前正在使用的行中，使用过的单位数
        int eachRow = 0;
        for (int i = 0; i < s.length(); i++) {
            // 取字符
            char c = s.charAt(i);
            // 判断添加进当前行之后会不会大于 100
            // 如果大于，直接开启新行，并且把使用过的单位数置为 0
            // 注意：此处不能有 == 100，因为刚好等于 100 时是合法的，不用另起新行
            if (eachRow + widths[c - 'a'] > 100) {
                rowCnt++;
                eachRow = 0;
            }
            // 加上使用的单位数
            eachRow += widths[c - 97];
        }
        return new int[]{rowCnt, eachRow};
    }
}
