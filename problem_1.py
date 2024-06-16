# Time = O(n)
# Space = O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_val = max(nums)
        dp = [0 for _ in range(max_val+1)]
        for i in range(len(nums)):
            index = nums[i]
            dp[index] += index
        skip = 0
        take = dp[0]
        for k in range(1,max_val+1):
            tmp = skip 
            skip = max(skip,take)
            take = tmp + dp[k]
        return max(skip, take)

        
        