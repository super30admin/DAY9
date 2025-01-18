# Similar to house robber problem. Convert the problem into house robber by creating an array and storing the elements or incrementing them at their index
# TC: O(max(n, max(nums)))
# SC: O(max(nums))
# Yes this worked in leetcode

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        maxi = max(nums)
        dp = [0]*(maxi+1)
        for i in range(len(nums)):
            index = nums[i]
            dp[index] = dp[index] + nums[i]
        skip = 0
        take = 0
        for i in range(1, len(dp)):
            tempskip = skip
            skip = max(skip, take)
            take = tempskip + dp[i]

        return max(skip, take)
