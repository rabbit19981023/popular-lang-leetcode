const { Solution } = require('../src/longest_common_prefix')

describe('../src/longest_common_prefix.js', () => {
	it("Test: have longest common prefix", () => {
		const input = [ "flower", "flow", "flight" ]
		const expected = "fl"
	
		processTestCase(input, expected)
	})

	it("Test: no longest common prefix", () => {
		const input = [ "dog", "racecar", "car" ]
		const expected = ""
	
		processTestCase(input, expected)
	})
})

const solution = new Solution()

const processTestCase = function (input, expected) {
	const actual = solution.longestCommonPrefix(input)
	expect(actual).toBe(expected)
}
