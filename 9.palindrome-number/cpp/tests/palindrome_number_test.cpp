#include <gtest/gtest.h>
#include "../src/palindrome_number.h"

class Inputs {
public:
  int num;
};

void processTestCase(Inputs inputs, bool expected);

TEST(PalindromeNumberTest, PositiveNumber) {
  Inputs inputs {
    .num = 121
  };
  bool expected = true;

  processTestCase(inputs, expected);
}

TEST(PalindromeNumberTest, NegativeNumber) {
  Inputs inputs {
    .num = -121
  };
  bool expected = false;

  processTestCase(inputs, expected);
}

TEST(PalindromeNumberTest, ZeroEndingNumber) {
  Inputs inputs {
    .num = 10
  };
  bool expected = false;

  processTestCase(inputs, expected);
}

PalindromeNumber palindromeNumber;

void processTestCase(Inputs inputs, bool expected) {
  bool actual = palindromeNumber._do(inputs.num);
  ASSERT_EQ(actual, expected);
}
