class PalindromeNumber:
  def do(self, num: int) -> bool:
    if self.isNegative(num) or self.isZeroEnding(num):
      return False

    reverted = 0

    while num > reverted:
      reverted = (
        self.carry_by_1_digit(reverted) +
        self.get_last_digit(num)
      )
      num = self.delete_last_digit(num)

    return (num == reverted) or (num == reverted // 10)

  def isNegative(self, num: int) -> bool:
    return num < 0

  def isZeroEnding(self, num: int) -> bool:
    return (num % 10 == 0)

  def carry_by_1_digit(self, reverted: int) -> int:
    return reverted * 10

  def get_last_digit(self, num: int) -> int:
    return num % 10

  def delete_last_digit(self, num: int) -> int:
    return num // 10
