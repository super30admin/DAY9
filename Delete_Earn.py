# Time complexity O(n + max(nums[i])) 
# Space complexity O(max(nums[i]))
from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        max1 = 0
        for i in range(len(nums)):
            max1 = max(max1, nums[i])
        skip = 0
        take = 0 
        dp =  [0] * (max1 +1)

        for i in range(len(nums)):
            index =  nums[i]
            dp[index] += nums[i]
        skip = 0
        take = 0

        for i in range(1, len(dp)):
            tempskip = skip
            skip = max(skip, take)
            take = tempskip + dp[i]

        return max(skip, take)


        