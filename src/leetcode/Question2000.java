package leetcode;

public class Question2000 {
    public String reversePrefix(String word, char ch) {
        // 边界确定
        if (word.length() < 1 || word.length() > 250) {
            return "";
        }
        // 下标变量
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                index = i;
                // 找出后即跳出，否则有被重新赋值的风险
                break;
            }
        }
        // 若下标为初始赋值，则说明没有找到目标字符，直接返回
        if (index == 0) {
            return word;
        }
        // 多线程中建议 StringBuffer
        // 结果字符串构造器
        StringBuilder result = new StringBuilder();
        // 这里可以用替代解决方案，即将符合目的的前缀统一挪到 result 中
        // 然后用 StringBuilder 自带的 reverse 方法进行翻转，其效果差不多
        for (int i = index; i >= 0; i--) {
            result.append(word.charAt(i));
        }
        // 最后拼接源字符串前缀其后的余下字符串
        return result.append(word.substring(index + 1)).toString();
    }
}
