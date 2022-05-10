package leetcode;

public class Question53 {
    /**
     * dp 未优化
     * @param nums
     * @return
     */
    public static int maxSubArray_dp_noOptimize(int[] nums) {
        // 边界判断
        if (nums.length < 1 || nums.length > 100000) {
            return 0;
        }
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 遍历一次数组，求出 dp[] 数组的值，将最大值保存其中
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        int result = dp[0];
        // 找出最大值
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    /**
     * dp 优化
     * @param nums
     * @return
     */
    public static int maxSubArray_dp_optimize(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 分治，配合子方法
     * @param nums
     * @return
     */
    public static int maxSubArray_divide(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private static int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private static int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public static int maxSubArray_force(int[] nums) {
        int max = Integer.MIN_VALUE;
        int numsSize = nums.length;
        for (int i = 0; i < numsSize; i++) {
            int sum = 0;
            for (int j = i; j < numsSize; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
