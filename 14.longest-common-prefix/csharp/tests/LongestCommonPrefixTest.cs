using Microsoft.VisualStudio.TestTools.UnitTesting;
using Leetcode;

namespace LeetcodeTest
{
    [TestClass]
    public class LongestCommonPrefixTest
    {
        Solution solution = new Solution();

        private void ProcessTestCase(string[] input, string expected)
        {
            string actual = solution.LongestCommonPrefix(input);
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        public void have_longest_common_prefix()
        {
            string[] input = new string[] { "flower","flow","flight" };
            string expected = "fl";

            ProcessTestCase(input, expected);
        }

        [TestMethod]
        public void no_longest_common_prefix()
        {
            string[] input = new string[] { "dog","racecar","car" };
            string expected = "";

            ProcessTestCase(input, expected);
        }
    }
}
