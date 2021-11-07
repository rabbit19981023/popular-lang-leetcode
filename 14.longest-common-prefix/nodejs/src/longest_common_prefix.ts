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

export { Solution }
