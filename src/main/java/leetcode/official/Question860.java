package leetcode.official;

public class Question860 {
    /**
     * 暴力模拟
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills[0] != 5) return false;
        int[] remains = new int[]{0, 0};
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    remains[0]++;
                    break;
                case 10:
                    if (remains[0] <= 0) return false;
                    else {
                        remains[0]--;
                        remains[1]++;
                    }
                    break;
                case 20:
                    if (remains[0] < 1) return false;
                    else {
                        remains[0]--;
                        if (remains[1] >= 1) remains[1]--;
                        else {
                            if (remains[0] < 2) return false;
                            else remains[0] -= 2;
                        }
                    }
            }
        }
        return true;

        // 优质算法，其实差不多
//        int five = 0, ten = 0;
//        for (int i : bills) {
//            if (i == 5) five++;
//            else if (i == 10) {five--; ten++;}
//            else if (ten > 0) {ten--; five--;}
//            else five -= 3;
//            if (five < 0) return false;
//        }
//        return true;
    }
}
