package leetcode.official;

public class Question88 {

    /**
     * 最终选择：2
     * <p>
     * 1. 直接在 nums1 上进行操作，比较麻烦
     * 2. 新开一个大小相同的数组，排序完毕之后赋值给 nums1 比较简单
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[nums1.length];
        int idx1 = 0, idx2 = 0, idx = 0;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] <= nums2[idx2]) {
                sorted[idx] = nums1[idx1++];
            } else {
                sorted[idx] = nums2[idx2++];
            }
            idx++;
        }
        if (idx1 >= m) {
            while (idx2 < n) {
                sorted[idx++] = nums2[idx2++];
            }
        } else {
            while (idx1 < m) {
                sorted[idx++] = nums1[idx1++];
            }
        }
        System.arraycopy(sorted, 0, nums1, 0, sorted.length);


//        此解法比较漂亮，可以参考一下
//        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
//        while (tail1 >= 0 && tail2 >= 0) {
//            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
//        }
//        while (tail2 >= 0) {
//            nums1[finished--] = nums2[tail2--];
//        }
    }
}
