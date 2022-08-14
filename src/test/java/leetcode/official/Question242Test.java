package leetcode.official;

import junit.framework.TestCase;

public class Question242Test extends TestCase {

    public void testOne() {
        assertTrue(Question242.isAnagram("anagram","nagaram"));
    }

    public void testTwo() {
        assertFalse(Question242.isAnagram("rat","cat"));
    }
}