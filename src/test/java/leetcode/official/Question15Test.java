package leetcode.official;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Question15Test extends TestCase {
    public void test1() {
        List<List<Integer>> lists = Question15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> judge = new ArrayList<>();
        addList(judge,  -1, -1, 2);
        addList(judge,  -1, 0, 1);
        assertEquals(judge, lists);
    }

    public void test2() {
        List<List<Integer>> lists = Question15.threeSum(new int[]{0,1,1});
        List<List<Integer>> judge = new ArrayList<>();
        assertEquals(judge, lists);
    }

    public void test3() {
        List<List<Integer>> lists = Question15.threeSum(new int[]{0,0,0});
        List<List<Integer>> judge = new ArrayList<>();
        addList(judge,  0, 0, 0);
        assertEquals(judge, lists);
    }

    public void test4() {
        List<List<Integer>> lists = Question15.threeSum(new int[]{1,5,-4,7,-3,-2});
        List<List<Integer>> judge = new ArrayList<>();
        addList(judge,  -4,-3,7);
        addList(judge,  -3,-2,5);
        assertEquals(judge, lists);

    }

    private void addList(List<List<Integer>> judge, int... elements) {
        ArrayList<Integer> element = new ArrayList<>();
        for (int j : elements) {
            element.add(j);
        }
        judge.add(element);
    }
}