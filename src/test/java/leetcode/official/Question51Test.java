package leetcode.official;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Question51Test extends TestCase {
    public void testOne() {
        List<List<String>> expect = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add(".Q..");
        one.add("...Q");
        one.add("Q...");
        one.add("..Q.");
        List<String> two = new ArrayList<>();
        two.add("..Q.");
        two.add("Q...");
        two.add("...Q");
        two.add(".Q..");
        expect.add(one);
        expect.add(two);
        assertEquals(expect, Question51.solveNQueens(4));
    }
}