# ---- To make source files can be found by Python ---- #
import os
import sys

test_file_dir = os.path.dirname(__file__)
src_file_dir = os.path.dirname(test_file_dir) + "/src"
module_path = sys.path

module_path.append(src_file_dir)

# ---- Unit Tests ---- #
import unittest
from longest_common_prefix import Solution

class TestCases(unittest.TestCase):
	solution = Solution()

	def process_test_case(self, _input, expected):
		result = self.solution.longest_common_prefix(_input)
		self.assertEqual(result, expected)

	def test_case_01(self):
		_input = [ "flower", "flow", "flight" ]
		expected = "fl"

		self.process_test_case(_input, expected)

	def test_case_02(self):
		_input = [ "dog", "racecar", "car" ]
		expected = ""

		self.process_test_case(_input, expected)

if __name__ == '__main__':
	unittest.main()
