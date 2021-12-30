class PalindromeNumber {
public:
  bool _do(int num);

private:
  bool isNegative(int num);
  bool isZeroEnding(int num);
  int carryBy1Digit(int convertedNumber);
  int getLastDigit(int num);
  int deleteLastDigit(int num);
};

bool PalindromeNumber::_do(int num) {
  if (isNegative(num) | isZeroEnding(num)) {
    return false;
  }

  int convertedNumber = 0;

  while (num > convertedNumber) {
    convertedNumber = (carryBy1Digit(convertedNumber)
                      + getLastDigit(num));
    num = deleteLastDigit(num);
  }

  return (num == convertedNumber) || (num == (convertedNumber / 10));
}

bool PalindromeNumber::isNegative(int num) {
  return num < 0;
}

bool PalindromeNumber::isZeroEnding(int num) {
  return (num % 10) == 0;
}

int PalindromeNumber::carryBy1Digit(int convertedNumber) {
  return convertedNumber * 10;
}

int PalindromeNumber::getLastDigit(int num) {
  return num % 10;
}

int PalindromeNumber::deleteLastDigit(int num) {
  return num / 10;
}
