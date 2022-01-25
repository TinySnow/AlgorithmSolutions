import leetcode.Question1;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(Question1.twoSum(test, target)));
    }
}
