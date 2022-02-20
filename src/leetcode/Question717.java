package leetcode;

public class Question717 {
    public boolean isOneBitCharacter(int[] bits) {
        // 遍历整个 bit 数组
        for (int i = 0; i < bits.length; i++) {
            // 如果倒数第二位不为 0 而为 1，则说明最后一位必定是连在倒数第二位上的第二种字符
            // 如果倒数第二位为 0 则直接返回 true，不用看最后一位，因为题目中保证最后一位为 0
            if (i == bits.length - 2){
                return bits[i] == 0;
            }
            // 在遇到倒数第二位之前，如果该位置上为 1，则直接跳过下一位
            if (bits[i] == 1) {
                i++;
            }
        }
        // 遍历完了走到这一步，说明直接跳过了上面判断倒数第二位那步逻辑
        // 也即是说，最后一位必定为 0（题目中保证），并且倒数第三位必定为 1（因为跳过了倒数第二位）
        // 所以最后必定是 1 X 0，为 true，返回 true
        return true;
    }
}
