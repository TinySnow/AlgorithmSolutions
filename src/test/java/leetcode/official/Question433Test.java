package leetcode.official;

import junit.framework.TestCase;

public class Question433Test extends TestCase {

    public void testOne() {
        assertEquals(1, Question433.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }

    public void testTwo() {
        assertEquals(2, Question433.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }

    public void testThree() {
        assertEquals(3, Question433.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}