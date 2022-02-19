package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 草，竟然一次过了
 */
public class Question969 {
    public static List<Integer> pancakeSort(int[] arr) {
        // 边界判断
        if (arr.length > 100) {
            return null;
        }
        // 结果 List
        List<Integer> result = new ArrayList<>();
        // 先排好序作为终止循环的依据
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        // 调试用
//        System.out.println("Sorted: " + Arrays.toString(sorted));
        // 因为每次把最大的数翻到后面去，会将子数组长度减一，所以不能直接用 arr.length
        int length = arr.length;
        // 如果没排好序就进行循环
        while (!Arrays.equals(arr,sorted)) {
            // 尾指针
            int rear = 0;
            // 找出未排好序时，子数组里最大的那个数的下标值
            for (int i = 0; i < length; i++) {
                if (arr[i] >= arr[rear]) {
                    rear = i;
                }
            }
            // 如果最大的数就在第一个，那么其实就不用进行这一次翻转
            // 如果进行翻转，结果数组里会多一个 1 出来，其实就是自己跟自己交换，没有意义
            if (rear != 0) {
                result.add(rear + 1);
                exchange(arr, 0, rear);
            }
            // 上面交换之后会把最大的数置换到第一位，所以在接下来还会交换整个子数组，将它换到最后面去
            // 所以这里添加一个翻转长度：整个子数组的长度
            result.add(length);
            // 翻转整个子数组
            exchange(arr, 0, length - 1);
            // 调试用
//            System.out.println(Arrays.toString(arr));
            // 将子数组的长度减一，再次进行循环和排序
            length--;
        }
        // 返回结果集
        return result;
    }

    private static void exchange(int[] arr, int front, int rear) {
        while (front < rear) {
            int tmp = arr[front];
            arr[front] = arr[rear];
            arr[rear] = tmp;
            front++;
            rear--;
        }
    }
}
