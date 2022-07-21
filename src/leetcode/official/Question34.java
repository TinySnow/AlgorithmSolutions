package leetcode.official;

public class Question34 {
    public static int[] searchRange(int[] nums, int target) {
        // 边界判断
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 二分搜索，根据结果进行最后取值和返回
        Integer index = binarySearch(nums, target);
        if (index == null) {
            return new int[]{-1, -1};
        }
        // 寻找左界为 true，右界为 false
        int leftEdge = lookForEdge(nums, 0, index, true);
        int rightEdge = lookForEdge(nums, index, nums.length - 1, false);
        //返回
        return new int[]{leftEdge, rightEdge};
    }

    private static int lookForEdge(int[] nums, Integer left, Integer right, boolean flag) {
        // 如果是寻找左界，则 right 是我们想要的数，寻找右界的 left 同理
        int standard = flag ? right : left;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            // 中间即为我们想要的数字时
            if (nums[middle] == nums[standard]) {
                // 寻找左界，就将右界往左缩，寻找右界，就将左界往右缩
                if (flag) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            // 中间不为我们想要的数字时
            else {
                // 寻找左界，就将左界往右缩，寻找右界，就将右界往左缩
                if (flag) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        // 这里情况比较复杂，自己推演一下
        return flag ? left : right;
    }

    /**
     * 进行二分搜索，搜索到目标数字停下
     *
     * @param nums
     * @param target
     * @return 返回所有匹配 target 的数组下标值，无序。如果为 null，则说明没有结果。
     */
    private static Integer binarySearch(int[] nums, int target) {
        // 找到中间值
        // 标准二分模板
        int left = 0;
        int right = nums.length - 1;
        int index = left + (right - left) / 2;
        while (left <= right) {
            index = left + (right - left) / 2;
            if (nums[index] == target) {
                break;
            } else if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        // 1. 循环跳出，找到值
        // 2. 循环结束，未找到值
        // 判断是否是第二种情况
        return nums[index] != target ? null : index;
    }
}
