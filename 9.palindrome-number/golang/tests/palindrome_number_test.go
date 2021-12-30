package tests

import (
	"testing"
	"github.com/stretchr/testify/assert"
	"palindrome-number/src"
)

type Inputs struct {
	num int
}

func TestPositiveNumber(t *testing.T) {
	inputs := Inputs {
		num: 121,
	}
	expected := true
	
	processTestCase(t, inputs, expected)
}

func processTestCase(t *testing.T, inputs Inputs, expected bool) {
	actual := solution.IsPalindrome(inputs.num)
	assert.Equal(t, expected, actual)
}
