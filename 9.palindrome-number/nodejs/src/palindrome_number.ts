class PalindromeNumber {
  public do(num: number): boolean {
    if (this.isNegative(num) || this.isZeroEnding(num)) {
      return false
    }

    let convertedNumber = 0

    while (num > convertedNumber) {
      convertedNumber = (this.carryBy1Digit(convertedNumber)
                        + this.getLastDigit(num))
      num = this.deleteLastDigit(num)
    }

    return (num == convertedNumber) || (num == Math.floor(convertedNumber / 10))
  }

  private isNegative(num: number): boolean {
    return num < 0
  }

  private isZeroEnding(num: number): boolean {
    return num % 10 === 0
  }

  private carryBy1Digit(convertedNumber: number): number {
    return convertedNumber * 10
  }

  private getLastDigit(num: number): number {
    return num % 10
  }

  private deleteLastDigit(num: number): number {
    return Math.floor(num / 10)
  }
}

export { PalindromeNumber }
