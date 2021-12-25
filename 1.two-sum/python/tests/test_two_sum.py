import unittest
from src.two_sum import Solution

class TwoSumTest(unittest.TestCase):
  solution = Solution()

  def processTestCase(self, inputs, expected):
    actual = self.solution.two_sum(inputs)
    self.assertEqual(actual, expected)

  def test_case_01(self):
    inputs = {}
    inputs["nums"] = [2, 7, 11, 15]
    inputs["target"] = 9
    expected = [0, 1]

    self.processTestCase(inputs, expected)

  def test_case_02(self):
    inputs = {}
    inputs["nums"] = [3,2,4]
    inputs["target"] = 6
    expected = [1,2]

    self.processTestCase(inputs, expected)

  def test_case_03(self):
    inputs = {}
    inputs["nums"] = [3,3]
    inputs["target"] = 6
    expected = [0,1]

    self.processTestCase(inputs, expected)
