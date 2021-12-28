class TwoSum {
  _do(nums: number[], target: number): number[] {
    const map = {}

    for (let i = 0; i < nums.length; i++) {
      const current = nums[i]
      const diff = target - current

      if (current in map) {
        return [map[current], i]
      }

      map[diff] = i
    }

    return []
  }
}

export { TwoSum }
