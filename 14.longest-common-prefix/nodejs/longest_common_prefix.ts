class Solution {
    public longestCommonPrefix(strs: string[]): string {
        if (! this.isValid(strs)) {
            return ""
        }

        let low: number = 1
        let high: number = this.getMinLen(strs)
        let mid: number

        while (low <= high) {
            mid = this.toInt((low + high) / 2)

            if (this.isCommonPrefix(mid, strs)) {
                low = mid + 1
                continue
            }

            high = mid - 1
        }

        const result = this.toInt((low + high) / 2)
        return strs[0].slice(0, result)
    }

    private isValid(strs: string[]): boolean {
        return ! (strs === undefined || strs === null || strs.length === 0)
    }

    private getMinLen(strs: string[]): number {
        let minLen: number = strs[0].length

        for (let i = 1; i < strs.length; i++) {
            if (strs[i].length < minLen) {
                minLen = strs[i].length
            }
        }

        return minLen
    }

    private toInt(num: number): number {
        return Math.trunc(num)
    }

    private isCommonPrefix(mid: number, strs: string[]): boolean {
        const prefix: string = strs[0].slice(0, mid)

        for (let i = 1; i < strs.length; i++) {
            if (! (strs[i].startsWith(prefix))) {
                return false
            }
        }

        return true
    }
}

class Test {
    strs: string[]

    constructor(strs: string[]) {
        this.strs = strs
    }
}

// Test Case
const test_01: Test = new Test([ "flower", "flow", "flight" ])
const test_02: Test = new Test([ "dog", "racecar", "car" ])

const solution: Solution = new Solution()

const result_01: string = solution.longestCommonPrefix(test_01.strs)
const result_02: string = solution.longestCommonPrefix(test_02.strs)

console.log()
console.log("Expected: 'fl'\n" + "Output: " + result_01)
console.log()

console.log("Expected: ''\n" + "Output: " + result_02)
console.log()
