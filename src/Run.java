import leetcode.school.BackpackBackTrackSolution;

public class Run {
    public static void main(String[] args) {
        BackpackBackTrackSolution solution = new BackpackBackTrackSolution();
        solution.backTrack(0);
        System.out.println("该背包能够取到的最大价值为:" + solution.maxValue);
        System.out.println("当前背包的重量为:" + solution.capacity);
        System.out.println("物品的装入和取出方法为:");
        for (int i : solution.bestWay)
            System.out.print(i + "  ");
    }
}