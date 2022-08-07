package leetcode.official;

import junit.framework.TestCase;
import org.junit.Test;

public class Question70Test extends TestCase {
    public void test(){
        assertEquals(0,Question70.climbStairs(0));
        assertEquals(1,Question70.climbStairs(1));
        assertEquals(2,Question70.climbStairs(2));
        assertEquals(3,Question70.climbStairs(3));
        assertEquals(5,Question70.climbStairs(4));
        assertEquals(8,Question70.climbStairs(5));
        assertEquals(13,Question70.climbStairs(6));
        assertEquals(21,Question70.climbStairs(7));
        assertEquals(34,Question70.climbStairs(8));
    }
}