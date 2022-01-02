package tests

import (
	"github.com/stretchr/testify/assert"
	"palindrome-number/src"
	"testing"
)

type Inputs struct {
	num int
}

func TestPositiveNumber(t *testing.T) {
	inputs := Inputs{
		num: 121,
	}
	expected := true

	processTestCase(t, inputs, expected)
}

func TestNegitiveNumber(t *testing.T) {
	inputs := Inputs{
		num: -121,
	}
	expected := false

	processTestCase(t, inputs, expected)
}

func TestZeroEndingNumber(t *testing.T) {
	inputs := Inputs{
		num: 10,
	}
	expected := false

	processTestCase(t, inputs, expected)
}

func processTestCase(t *testing.T, inputs Inputs, expected bool) {
	actual := solution.IsPalindrome(inputs.num)
	assert.Equal(t, expected, actual)
}
