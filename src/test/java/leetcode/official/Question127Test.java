package leetcode.official;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class Question127Test extends TestCase {

    public void testOne() {
        int result = Question127.ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(5, result);
    }

    public void testTwo() {
        int result = Question127.ladderLength("hot", "dog",
                new ArrayList<>(Arrays.asList("hot", "dog", "dot")));
        assertEquals(3, result);
    }

    public void testThree() {
        int result = Question127.ladderLength("hot", "dog",
                new ArrayList<>(Arrays.asList("hot", "dog")));
        assertEquals(0, result);
    }
}