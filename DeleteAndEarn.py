#---------Convert into house roober------------------------
#--------Time O(n) + O(max(n)), Space O(max(n))
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_len = max(nums)
        arr = [0 for _ in range(max_len + 1)]
        
        for num in nums: # O(n)
            arr[num] += num
        
        skip = 0
        take = arr[0]

        for i in arr: # O(max(nums))
            skip, take = max(skip, take), i + skip
        return max(skip, take)
        