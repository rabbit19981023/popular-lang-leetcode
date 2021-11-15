package tests

import (
	"github.com/stretchr/testify/assert"
	"leetcode/src" // follow the project structure
	"testing"
)

func processTestCase(t *testing.T, input []string, expected string) {
	actual := solution.LongestCommonPrefix(input)
	assert.Equal(t, expected, actual)
}

func Test_have_longest_common_prefix(t *testing.T) {
	input := []string{"flower", "flow", "flight"}
	expected := "fl"

	processTestCase(t, input, expected)
}

func Test_no_longest_common_prefix(t *testing.T) {
	input := []string{"dog", "racecar", "car"}
	expected := ""

	processTestCase(t, input, expected)
}
