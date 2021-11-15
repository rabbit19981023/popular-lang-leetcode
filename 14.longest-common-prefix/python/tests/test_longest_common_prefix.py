# ---- To make source files can be found by Python ---- #
import os
import sys

test_file_dir = os.path.dirname(__file__)
src_file_dir = os.path.dirname(test_file_dir) + "/src"

sys.path.append(src_file_dir)

# ---- Unit Tests ---- #
import unittest
from longest_common_prefix import Solution

class LongestCommonPrefixTest(unittest.TestCase):
	solution = Solution()

	def process_test_case(self, _input, expected):
		actual = self.solution.longest_common_prefix(_input)
		self.assertEqual(actual, expected)

	def test_have_longest_common_prefix(self):
		_input = [ "flower", "flow", "flight" ]
		expected = "fl"

		self.process_test_case(_input, expected)

	def test_no_longest_common_prefix(self):
		_input = [ "dog", "racecar", "car" ]
		expected = ""

		self.process_test_case(_input, expected)

if __name__ == '__main__':
	unittest.main()
