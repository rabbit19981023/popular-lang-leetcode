class PalindromeNumber {
  public do(num: number): boolean {
    if (this.isNegative(num) || this.isZeroEnding(num)) {
      return false
    }

    let converted = 0

    while (num > converted) {
      converted = (this.carryBy1Digit(converted)
                        + this.getLastDigit(num))
      num = this.deleteLastDigit(num)
    }

    return (num == converted) || (num == Math.floor(converted / 10))
  }

  private isNegative(num: number): boolean {
    return num < 0
  }

  private isZeroEnding(num: number): boolean {
    return num % 10 === 0
  }

  private carryBy1Digit(converted: number): number {
    return converted * 10
  }

  private getLastDigit(num: number): number {
    return num % 10
  }

  private deleteLastDigit(num: number): number {
    return Math.floor(num / 10)
  }
}

export { PalindromeNumber }
