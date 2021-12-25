class Solution:
  def two_sum(self, inputs):
    nums = inputs["nums"]
    target = inputs["target"]

    map_list = {}

    for i in range(len(nums)):
      current = nums[i]
      diff = target - current

      if current in map_list:
        return [map_list[current], i]

      map_list[diff] = i
