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
        String actual = solution.longestCommonPrefix(input);
        assertEquals(expected, actual);
    }
    
    @Test
    public void have_longest_common_prefix()
    {
        String[] input = new String[] { "flower", "flow", "flight" };
        String expected = "fl";

        process_test_case(input, expected);
    }

    @Test
    public void no_longest_common_prefix()
    {
        String[] input = new String[] { "dog", "rececar", "car" };
        String expected = "";

        process_test_case(input, expected);
    }
}
