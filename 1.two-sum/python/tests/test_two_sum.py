import unittest
from src.two_sum import TwoSum

class TwoSumTest(unittest.TestCase):
  two_sum = TwoSum()

  def test_case_01(self):
    inputs = {
      "nums": [2, 7, 11, 15],
      "target": 9
    }
    expected = [0, 1]

    self.processTestCase(inputs, expected)

  def test_case_02(self):
    inputs = {
      "nums": [3, 2, 4],
      "target": 6
    }
    expected = [1,2]

    self.processTestCase(inputs, expected)

  def test_case_03(self):
    inputs = {
      "nums": [3, 3],
      "target": 6
    }
    expected = [0,1]

    self.processTestCase(inputs, expected)

  def processTestCase(self, inputs, expected):
    nums = inputs["nums"]
    target = inputs["target"]
    actual = self.two_sum.do(nums, target)
    self.assertEqual(actual, expected)
