package examination;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class YiSheng {

    public static int result = 0;
    public static ArrayList<Integer> test = new ArrayList<>();

    public static int combinationSum(int[] candidates, int target) {
        if (candidates == null) return -1;
        Arrays.sort(candidates);
        dfs(candidates, target);
        return result;
    }

    private static void dfs(int[] candidates, int target) {
        // terminator
        int idx = -1;
        for (int i = 0; i < candidates.length; i++) {
            if (target < candidates[i]) {
                idx = i;
                break;
            } else if (target == candidates[i]) {
                result++;
            }
        }
        // level logic

        // drill down
        int end = idx == -1 ? candidates.length : idx;
        for (int i = 0; i < end; i++) {
            dfs(candidates, target - candidates[i]);
        }
        // clean
    }
}