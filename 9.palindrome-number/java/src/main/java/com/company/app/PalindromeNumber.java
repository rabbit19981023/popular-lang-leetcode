package com.company.app;

public class PalindromeNumber
{
    public boolean _do(int num)
    {
      if (isNegative(num) || isZeroEnding(num)) {
        return false;
      }

      int converted = 0;

      while (num > converted) {
        converted = carryBy1Digit(converted) + getLastDigit(num);
        num = deleteLastDigit(num);
      }

      return (num == converted) || (num == (converted / 10));
    }

    private boolean isNegative(int num)
    {
      return num < 0;
    }

    private boolean isZeroEnding(int num)
    {
      return num % 10 == 0;
    }

    private int carryBy1Digit(int converted)
    {
      return converted * 10;
    }

    private int getLastDigit(int num)
    {
      return num % 10;
    }

    private int deleteLastDigit(int num)
    {
      return num / 10;
    }
}
