package leetcode.official;

import java.util.ArrayList;
import java.util.List;

public class Question1260 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // 边界判断
        if (grid.length < 1 || grid.length > 50 || grid[0].length > 50 || k < 0 || k > 100) {
            return null;
        }
        int raws = grid.length;
        int columns = grid[0].length;
        int total = raws * columns;
        int[] doubleArray = new int[2 * total];
        // 将两个 grid 拼成一维数组
//        此处才用的是嵌套循环，效率不高，建议使用下面的单次循环
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                doubleArray[i * columns + j] = grid[i][j];
//                doubleArray[total + i * columns + j] = grid[i][j];
//            }
//        }
        // 单次循环拼接
        for (int i = 0; i < total; i++) {
            doubleArray[i] = grid[i / columns][i % columns];
            doubleArray[total + i] = grid[i / columns][i % columns];
        }
        // 算出真实的偏移位置，因为 k 可能很大（最大为 100），但是二维数组可能很小，所以需要取模映射到二维数组大小的范围内
        // k 为 0 时不偏移，其实也就相当于偏移了一整个原数组
        int realOffset = (total) - (k % (total));
        // 最后整理成 list 即可
        List<Integer> eachLine = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 执行 total 次，如果途中能整除 columns，则另起一个 List
        int count = 1;
        while (count <= total) {
            if (eachLine.size() != 0 && eachLine.size() % columns == 0) {
                result.add(eachLine);
                eachLine = new ArrayList<>();
            }
            eachLine.add(doubleArray[realOffset + count - 1]);
            count++;
        }
        // 最后循环结束，但是最后的 eachLine 还没有加入 result，此处补上
        result.add(eachLine);
        return result;
    }
}
