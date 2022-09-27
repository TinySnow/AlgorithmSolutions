package leetcode.official;

public class Question45 {
    public static int jump(int[] nums) {
        // 没做出来，想复杂了
//        if (nums == null) return -1;
//        if (nums.length == 1) return 0;
//        int target = nums.length - 1, count = 0, furthest = nums.length - 1;
//        while (target != 0) {
//            int i = 0;
//            if (nums[i] >= target) break;
//            while (i < target) {
//                if (nums[i] + i >= nums.length - 1) furthest = Math.min(furthest, i);
//                i++;
//            }
//            target = furthest;
//            count++;
//        }
//        return count;

        int steps = 0, end = 0, furthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == end) {
                steps++;
                end = furthest;
            }
        }
        return steps;
    }
}
