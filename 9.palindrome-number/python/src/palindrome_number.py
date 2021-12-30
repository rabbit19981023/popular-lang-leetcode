class PalindromeNumber:
  def do(self, num: int) -> bool:
    if (num < 0) or (num % 10 == 0):
      return False

    reverted_num = 0

    while num > reverted_num:
      reverted_num = (self.carry_by_1_digit(reverted_num)
                    + self.get_num_last_digit(reverted_num))
      num = self.delete_num_last_digit(num)

    return (num == reverted_num) or (num == reverted_num // 10)

  def carry_by_1_digit(self, reverted_num: int):
    return reverted_num * 10

  def get_num_last_digit(self, reverted_num: int):
    return reverted_num % 10

  def delete_num_last_digit(self, num: int):
    return num // 10
