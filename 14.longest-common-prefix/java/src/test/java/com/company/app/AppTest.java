package com.company.app; // this package include class: Solution

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests
 */
public class AppTest 
{

    Solution solution = new Solution();

    private void process_test_case(String[] input, String expected)
    {
        String result = solution.longestCommonPrefix(input);
        assertEquals(expected, result);
    }
    
    /**
     * Test Case 01
     */
    @Test
    public void testCase_01()
    {
        String[] input = new String[] { "flower", "flow", "flight" };
        String expected = "fl";

        process_test_case(input, expected);
    }

    /**
     *  Test Case 02
     */
    @Test
    public void testCase_02()
    {
        String[] input = new String[] { "dog", "rececar", "car" };
        String expected = "";

        process_test_case(input, expected);
    }
}
