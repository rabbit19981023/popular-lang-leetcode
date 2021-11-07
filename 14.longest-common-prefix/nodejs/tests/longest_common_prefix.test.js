const { Solution } = require('../src/longest_common_prefix')

const solution = new Solution()

const processTestCase = function (input, expected) {
	const result = solution.longestCommonPrefix(input)
	expect(result).toBe(expected)
}

test("TestCase 01", () => {
	const input = [ "flower", "flow", "flight" ]
	const expected = "fl"

	processTestCase(input, expected)
})

test("TestCase 02", () => {
	const input = [ "dog", "racecar", "car" ]
	const expected = ""

	processTestCase(input, expected)
})
