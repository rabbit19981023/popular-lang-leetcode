package company.app;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Unit tests
 */
public class TwoSumTest
{
    TwoSum twoSum = new TwoSum();

    @Test
    public void testCase01()
    {
        Inputs inputs = new Inputs();
        inputs.setNums(new int[] {2, 7, 11, 15})
              .setTarget(9);
      
        int[] expected = {0, 1};

        processTestCase(inputs, expected);
    }

    @Test
    public void testCase02()
    {
      Inputs inputs = new Inputs();
      inputs.setNums(new int[] {3, 2, 4})
            .setTarget(6);
      
      int[] expected = {1, 2};

      processTestCase(inputs, expected);
    }

    @Test
    public void testCase03()
    {
      Inputs inputs = new Inputs();
      inputs.setNums(new int[] {3, 3})
            .setTarget(6);

      int[] expected = {0, 1};

      processTestCase(inputs, expected);
    }

    public void processTestCase(Inputs inputs, int[] expected)
    {
        int[] actual = twoSum._do(inputs.getNums(), inputs.getTarget());
        assertArrayEquals(expected, actual);
    }

    private class Inputs
    {
        private int[] nums;
        private int target;

        public int[] getNums()
        {
          return this.nums;
        }

        public int getTarget()
        {
          return this.target;
        }

        public Inputs setNums(int[] nums)
        {
          this.nums = nums;
          return this;
        }

        public Inputs setTarget(int target)
        {
          this.target = target;
          return this;
        }
    }
}
