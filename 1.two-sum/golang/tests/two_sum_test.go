package tests

import (
	"github.com/stretchr/testify/assert"
	"testing"
	"two-sum/src"
)

type Inputs struct {
	nums   []int
	target int
}

func TestCase01(t *testing.T) {
	inputs := Inputs{
		nums:   []int{2, 7, 11, 15},
		target: 9,
	}
	expected := []int{0, 1}

	processTestCase(t, inputs, expected)
}

func TestCase02(t *testing.T) {
	inputs := Inputs{
		nums:   []int{3, 2, 4},
		target: 6,
	}
	expected := []int{1, 2}

	processTestCase(t, inputs, expected)
}

func TestCase03(t *testing.T) {
	inputs := Inputs{
		nums:   []int{3, 3},
		target: 6,
	}
	expected := []int{0, 1}

	processTestCase(t, inputs, expected)
}

func processTestCase(t *testing.T, inputs Inputs, expected []int) {
	actual := solution.TwoSum(inputs.nums, inputs.target)
	assert.Equal(t, expected, actual)
}
