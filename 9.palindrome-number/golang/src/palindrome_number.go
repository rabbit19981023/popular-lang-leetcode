package solution

func IsPalindrome(num int) bool {
	if isNegative(num) || isZeroEnding(num) {
		return false
	}

	converted := 0

	for num > converted {
		converted = carryBy1Digit(converted) + getLastDigit(converted)
		num = deleteLastDigit(num)
	}

	return (num == converted) || (num == (converted / 10))
}

func isNegative(num int) bool {
	return num < 0
}

func isZeroEnding(num int) bool {
	return (num%10 == 0)
}

func carryBy1Digit(converted int) int {
	return converted * 10
}

func getLastDigit(num int) int {
	return num % 10
}

func deleteLastDigit(num int) int {
	return num / 10
}
