package tests

import (
	"github.com/stretchr/testify/assert"
	"leetcode/src" // follow the project structure
	"testing"
)

func processTestCase(t *testing.T, input []string, expected string) {
	result := solution.LongestCommonPrefix(input)
	assert.Equal(t, expected, result, "They should be equal")
}

func Test_Case_01(t *testing.T) {
	input := []string{"flower", "flow", "flight"}
	expected := "fl"

	processTestCase(t, input, expected)
}

func Test_Case_02(t *testing.T) {
	input := []string{"dog", "racecar", "car"}
	expected := ""

	processTestCase(t, input, expected)
}
