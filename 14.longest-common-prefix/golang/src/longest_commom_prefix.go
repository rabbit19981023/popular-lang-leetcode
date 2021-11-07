package solution

import (
	"strings"
)

func LongestCommonPrefix(strs []string) string {
	if !isValid(strs) {
		return ""
	}

	low := 1
	high := getMinLen(strs)
	var mid int

	for low <= high {
		mid = (low + high) / 2

		if isCommonPrefix(mid, strs) {
			low = mid + 1
			continue
		}

		high = mid - 1
	}

	result := (low + high) / 2
	return strs[0][0:result]
}

func isValid(strs []string) bool {
	return !(strs == nil || len(strs) == 0)
}

func getMinLen(strs []string) int {
	minLen := len(strs[0])

	for i := 1; i < len(strs); i++ {
		if len(strs[i]) < minLen {
			minLen = len(strs[i])
		}
	}

	return minLen
}

func isCommonPrefix(mid int, strs []string) bool {
	prefix := strs[0][0:mid]

	for i := 1; i < len(strs); i++ {
		if !strings.HasPrefix(strs[i], prefix) {
			return false
		}
	}

	return true
}
