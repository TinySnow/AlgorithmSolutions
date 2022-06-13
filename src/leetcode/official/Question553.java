package leetcode.official;

/**
 * UNFINISHED
 * 没时间
 */

/**
 * 2022.4.4 补完
 * 数学分析贪心即可
 */
public class Question553 {
    public String optimalDivision(int[] nums) {
        // 只有一个数
        if (nums.length == 1){
            return String.valueOf(nums[0]);
        }
        // 两个数需要返回表达式
        if (nums.length == 2){
            return nums[0] + "/" + nums[1];
        }
        // 后面依次组合，分母最小即可
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        builder.append("/(");
        builder.append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            builder.append('/');
            builder.append(nums[i]);
        }
        builder.append(')');
        return builder.toString();
    }
}
