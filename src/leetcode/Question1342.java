package leetcode;

public class Question1342 {
    public static int numberOfSteps(int num) {
        if (num <0 || num >= 1000000){
            return -1;
        }
        boolean isOdd = num % 2 == 1;
        int count = 0;
        while (num != 0) {
            if (isOdd){
                num -= 1;
                isOdd = false;
            }else {
                num /= 2;
                isOdd = num % 2 == 1;
            }
            count++;
        }
        return count;
    }
}
