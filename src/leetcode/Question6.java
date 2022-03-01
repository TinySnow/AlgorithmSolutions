package leetcode;

public class Question6 {
    public static String convert(String s, int numRows) {
        // 边界确定
        if (s.length() < 1 || s.length() > 1000 || numRows < 1 || numRows > 1000) {
            return "";
        }
        // 确定目前的列数
        int column = 0;
        // 字符数组，用于 Z 字排列
        char[][] arrange = new char[numRows][s.length()];
        // 如果要求一行 Z 字排列
        if (numRows == 1) {
            return s;
        }
        // 对待排字符进行遍历
        for (int i = 0; i < s.length(); ) {
            // Z 字排列的横（竖）方向
            for (int j = 0; j < numRows && i < s.length(); j++) {
                // 如果是折回第一行，那么第一行的字母就已经被填入数组中，所以下一位置应该在第二行
                // 我们需要将字符行数加一位，否则当前进入的字母会被替换覆盖
                if (column != 0 && j == 0) {
                    j++;
                }
                // 保存进入数组
                arrange[j][column] = s.charAt(i++);
            }
            // Z 字排列撇折方向
            for (int j = numRows - 2; j >= 0 && i < s.length(); j--) {
                arrange[j][++column] = s.charAt(i++);
            }
        }
        // 结果
        StringBuilder result = new StringBuilder();
        // 遍历数组，遇空跳过
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arrange[i][j] != '\u0000') {
                    result.append(arrange[i][j]);
                }
            }
        }
        return result.toString();
    }
}
