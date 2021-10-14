class Solution:
    def longest_common_prefix(self, strs: list[str]) -> str:
        if (not self.is_valid(strs)):
            return ""
        
        low = 1
        high = self.get_min_length(strs)

        while(low <= high):
            mid = (low + high) // 2
            if self.is_common_prefix(strs, mid):
                low = mid + 1
            else:
                high = mid - 1

        result = (low + high) // 2
        return strs[0][0:result]
        
    def is_valid(self, strs: list[str]) -> bool:
        if (strs == None or len(strs) == 0):
            return False

        return True

    def get_min_length(self, strs: list[str]) -> int:
        minStr = min(strs, key=len)
        return len(minStr)

    def is_common_prefix(self, strs: list[str], mid: int) -> bool:
        prefix = strs[0][0:mid]
        for i in range(1, len(strs)):
            if not strs[i].startswith(prefix):
                return False

        return True

class Test:
    def __init__(self, strs: list[str]):
        self.strs = strs

# Test Case
solution = Solution()
test_01 = Test([ "flower","flow","flight" ])
test_02 = Test([ "dog","racecar","car" ])

print()
print("Expected: 'fl'" + "\n" + "Output: " + solution.longest_common_prefix(test_01.strs))
print()
print("Expected: ''" + "\n" + "Output: " + solution.longest_common_prefix(test_02.strs))
print()
