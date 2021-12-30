import unittest
from src.palindrome_number import PalindromeNumber

class PalindromeNumberTest(unittest.TestCase):
  palindrome_number = PalindromeNumber()

  def test_positive_number(self):
    inputs = {
      "n": 121
    }
    expected = True

    self.process_test_case(inputs, expected)

  def test_negative_number(self):
    inputs = {
      "n": -121
    }
    expected = False

    self.process_test_case(inputs, expected)

  def test_zero_ending_number(self):
    inputs = {
      "n": 10
    }
    expected = False

    self.process_test_case(inputs, expected)

  def process_test_case(self, inputs: dict, expected: bool):
    actual = self.palindrome_number.do(inputs["n"])
    self.assertEqual(actual, expected)
