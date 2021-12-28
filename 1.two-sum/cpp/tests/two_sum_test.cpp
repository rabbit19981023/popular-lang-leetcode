#include <gtest/gtest.h>
#include "../src/two_sum.h"

class Inputs {
public:
  vector<int> nums;
  int target;
};

void processTestCase(Inputs inputs, vector<int> expected);

TEST(TwoSumTest, TestCase01) {
  Inputs inputs {
    .nums = { 2, 7, 11, 15 },
    .target = 9
  };
  vector<int> expected = { 0, 1 };

  processTestCase(inputs, expected);
};

TEST(TwoSumTest, TestCase02) {
  Inputs inputs {
    .nums = { 3, 2, 4 },
    .target = 6
  };
  vector<int> expected = { 1, 2 };

  processTestCase(inputs, expected);
};

TEST(TwoSumTest, TestCase03) {
  Inputs inputs {
    .nums = { 3, 3 },
    .target = 6
  };
  vector<int> expected = { 0, 1 };

  processTestCase(inputs, expected);
};

//TwoSum* twoSum_ptr = new TwoSum();
//TwoSum twoSum = *twoSum_ptr;

TwoSum twoSum { };

void processTestCase(Inputs inputs, vector<int> expected) {
  vector<int> actual = twoSum._do(inputs.nums, inputs.target);
  ASSERT_EQ(actual, expected);
}
