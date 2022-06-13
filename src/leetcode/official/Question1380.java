package leetcode.official;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question1380 {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        // 边界判断
        if (matrix.length < 1 || matrix.length > 50 || matrix[0].length < 1 || matrix[0].length > 50) {
            return null;
        }
        // 存放每列最大值
        ArrayList<Integer> columnMax = new ArrayList<>(matrix[0].length);
        // 存放每行最小值
        ArrayList<Integer> rowMin = new ArrayList<>(matrix.length);
        // 遍历矩阵
        for (int i = 0; i < matrix.length; i++) {
            // 开始把每行第一个数默认为每行最小值
            int rowMinNum = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                // 遍历矩阵每行时，每次取当前值与已知最小值进行比较，并赋值保存
                rowMinNum = Math.min(matrix[i][j], rowMinNum);
                if (i == 0) {
                    // 如果为第一行，则默认第一行所有数为该列的最大值
                    columnMax.add(matrix[i][j]);
                } else {
                    // 如果为其他行，则与已知最大值进行比较，并存入相应位置
                    columnMax.set(j, Math.max(columnMax.get(j), matrix[i][j]));
                }
            }
            // 将每一行遍历得出的最小值，推入数组
            rowMin.add(rowMinNum);
        }
        // 找出相同的元素，变成形成集合返回
        return rowMin.stream().filter(columnMax::contains).collect(Collectors.toList());
    }
}
