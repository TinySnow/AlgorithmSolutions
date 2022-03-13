package leetcode;

public class Question393 {
    public static boolean validUtf8(int[] data) {
        // 边界判断
        if (data.length < 1 || data.length > 20000) {
            return false;
        }
        // 记录当前起始 utf8 编码第一个字节信息，也即需要几个字节表示，默认为 0
        // n 字节字符需要 n 个字节，此处 number 保存这个 n
        // 然后后续根据 n 判断是否轮到下一个字符
        int number = 0;
        for (int n : data) {
            if (number == 0) {
                if (n >= 0 && n <= 127) {
                    // 如果范围在这之内，说明为 1 字节字符，不需进行后续字节判断
                    // number 置为 0，直接开始下一轮字符判断即可
                    number = 0;
                } else if (n >= 192 && n <= 223) {
                    // 如果范围在这之内，说明为 2 字节字符，需进行后续的 1 个字节判断
                    number = 1;
                } else if (n >= 224 && n <= 239) {
                    // 如果范围在这之内，说明为 3 字节字符，需进行后续的 2 个字节判断
                    number = 2;
                } else if (n >= 240 && n <= 247) {
                    // 如果范围在这之内，说明为 4 字节字符，需进行后续的 3 个字节判断
                    number = 3;
                } else {
                    // 其他情况，说明直接编码错误，返回 false
                    return false;
                }
            } else {
                // 后续字节应该以 10 开头，所以如果在这个范围内，说明是合法的，字节判断数量减一，反之不合法
                if (n >= 128 && n <= 191) {
                    number--;
                } else {
                    return false;
                }
            }
        }
        // 最后判断是否循环完成，有可能最后一个字符需要进行字符判断
        // 但循环已经结束，返回 true 了，这是不合法的，所以需要 number 进行判断辅助
        // 如果最后一个字节刚好将字符判断数量清零，则说明合法
        // 如果字符判断数量没有清零就结束了循环，说明其后本来应该跟一些字符，但是没有跟，即不合法
        return number == 0;
    }
}
