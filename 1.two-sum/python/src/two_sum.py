class TwoSum:
  def do(self, nums, target):
    map_list = {}

    for i in range(len(nums)):
      current = nums[i]
      diff = target - current

      if current in map_list:
        return [map_list[current], i]

      map_list[diff] = i
