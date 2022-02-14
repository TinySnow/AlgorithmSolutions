package leetcode;

/**
 * UNFINISHED
 * 思路是对的，但是复杂了点。
 */
public class Question540 {
    public static int singleNonDuplicate(int[] nums) {
//        if (nums.length < 1 || nums.length > 100000) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int centralIndex = nums.length / 2;
//        boolean isOdd = centralIndex % 2 == 1;
//        int step;
//        while (true) {
//            if (isOdd) {
//                step = centralIndex / 2 + 1;
//                if (nums[centralIndex] == nums[centralIndex + 1]) {
//                    centralIndex -= step;
//                } else if (nums[centralIndex] == nums[centralIndex - 1]) {
//                    centralIndex += step;
//                } else {
//                    return nums[centralIndex];
//                }
//            } else {
//                step = centralIndex / 2;
//                if (nums[centralIndex] == nums[centralIndex + 1]) {
//                    centralIndex += step;
//                } else if (nums[centralIndex] == nums[centralIndex - 1]) {
//                    centralIndex -= step;
//                } else {
//                    return nums[centralIndex];
//                }
//            }
//            if (centralIndex == 0) {
//                return nums[0];
//            } else if (centralIndex == nums.length - 1) {
//                return nums[nums.length - 1];
//            } else {
//                isOdd = centralIndex % 2 == 1;
//            }
//        }
        /**
         * 以下是官方题解
         */
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
