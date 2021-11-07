#include <gtest/gtest.h>
#include "../src/longest_common_prefix.h"

void processTestCase(vector<string> input, string expected) {
	Solution* solution_ptr = new Solution();

	// since `solution_ptr` is a pointer which points to Solution class
	// just use `->` to access the class member
	string result = solution_ptr->longestCommonPrefix(input);
	ASSERT_EQ(result, expected);
}

TEST(LongestCommonPrefixTest, TestCase_01) {
	vector<string> input = { "flower", "flow", "flight" };
	string expected = "fl";
	processTestCase(input, expected);
}

TEST(LongestCommonPrefixTest, TestCase_02) {
	vector<string> input = { "dog", "racecar", "car" };
	string expected = "";
	processTestCase(input, expected);
}
