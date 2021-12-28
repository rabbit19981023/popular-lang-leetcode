import unittest
from src.longest_common_prefix import Solution

class LongestCommonPrefixTest(unittest.TestCase):
	solution = Solution()

	def test_have_longest_common_prefix(self):
		_input = [ "flower", "flow", "flight" ]
		expected = "fl"

		self.process_test_case(_input, expected)

	def test_no_longest_common_prefix(self):
		_input = [ "dog", "racecar", "car" ]
		expected = ""

		self.process_test_case(_input, expected)

	def process_test_case(self, _input, expected):
		actual = self.solution.longest_common_prefix(_input)
		self.assertEqual(actual, expected)
