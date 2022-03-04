package com.company.app; // this package include class: LongestCommonPrefix

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit Tests
 */
public class LongestCommonPrefixTest
{
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    public void haveLongestCommonPrefix()
    {
        Inputs inputs = new Inputs();
        inputs.setStrs(new String[] { "flower", "flow", "flight" });

        String expected = "fl";

        processTestCase(inputs, expected);
    }

    @Test
    public void noLongestCommonPrefix()
    {
        Inputs inputs = new Inputs();
        inputs.setStrs(new String[] { "dog", "rececar", "car" });

        String expected = "";

        processTestCase(inputs, expected);
    }

    private void processTestCase(Inputs inputs, String expected)
    {
        String actual = longestCommonPrefix._do(inputs.getStrs());
        assertEquals(expected, actual);
    }

    private class Inputs
    {
        private String[] strs;

        public String[] getStrs()
        {
            return this.strs;
        }

        public Inputs setStrs(String[] strs)
        {
            this.strs = strs;
            return this;
        }
    }
}
