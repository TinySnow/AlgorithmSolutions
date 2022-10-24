package examination;

import junit.framework.TestCase;

public class YiShengTest extends TestCase {

    public void testOne() {
        assertEquals(5, YiSheng.combinationSum(new int[]{2,3,4,5},9));
    }
}