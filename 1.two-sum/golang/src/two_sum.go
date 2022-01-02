package solution

func TwoSum(nums []int, target int) []int {
	m := map[int]int{}

	for i, num := range nums {
		diff := target - num

		if _, ok := m[num]; ok {
			return []int{m[num], i}
		}

		m[diff] = i
	}

	return []int{}
}
