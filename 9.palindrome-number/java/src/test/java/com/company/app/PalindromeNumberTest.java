package com.company.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests
 */
public class PalindromeNumberTest
{
    PalindromeNumber palindromeNumber = new PalindromeNumber();

    @Test
    public void positiveNumber()
    {
        Inputs inputs = new Inputs();
        inputs.setNum(121);
        
        boolean expected = true;

        processTestCase(inputs, expected);
    }

    @Test
    public void negativeNumber()
    {
        Inputs inputs = new Inputs();
        inputs.setNum(-121);

        boolean expected = false;

        processTestCase(inputs, expected);
    }

    @Test
    public void zeroEndingNumber()
    {
        Inputs inputs = new Inputs();
        inputs.setNum(10);

        boolean expected = false;

        processTestCase(inputs, expected);
    }

    private void processTestCase(Inputs inputs, boolean expected)
    {
        boolean actual = palindromeNumber._do(inputs.getNum());
        assertEquals(expected, actual);
    }

    private class Inputs
    {
        private int num;

        public int getNum()
        {
            return this.num;
        }

        public Inputs setNum(int num)
        {
            this.num = num;
            return this;
        }
    }
}
