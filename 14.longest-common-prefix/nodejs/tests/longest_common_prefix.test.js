const { Solution } = require('../src/longest_common_prefix')

const solution = new Solution()

const processTestCase = function (input, expected) {
	const actual = solution.longestCommonPrefix(input)
	expect(actual).toBe(expected)
}

test("Test: have longest common prefix", () => {
	const input = [ "flower", "flow", "flight" ]
	const expected = "fl"

	processTestCase(input, expected)
})

test("Test: no longest common prefix", () => {
	const input = [ "dog", "racecar", "car" ]
	const expected = ""

	processTestCase(input, expected)
})
