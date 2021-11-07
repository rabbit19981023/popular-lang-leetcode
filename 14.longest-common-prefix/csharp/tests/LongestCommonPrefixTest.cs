using Microsoft.VisualStudio.TestTools.UnitTesting;
using LeetCode;

namespace tests
{
    [TestClass]
    public class TestCases
    {
        Solution solution = new Solution();

        private void ProcessTestCase(string[] input, string expected)
        {
            string actual = solution.LongestCommonPrefix(input);
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        public void TestCase_01()
        {
            string[] input = new string[] { "flower","flow","flight" };
            string expected = "fl";

            ProcessTestCase(input, expected);
        }

        [TestMethod]
        public void TestCase_02()
        {
            string[] input = new string[] { "dog","racecar","car" };
            string expected = "";

            ProcessTestCase(input, expected);
        }
    }
}
