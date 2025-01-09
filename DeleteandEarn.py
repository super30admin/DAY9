class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # TC: O(n+maxv)
        # sc : O(maxv)
        if nums is None or len(nums) == 0:
            return 0
        maxv = max(nums)
        dp = [0]*(maxv+1)
        for i in range(len(nums)):
            dp[nums[i]] += nums[i]
        skip,take = 0,0
        for i in range(1,maxv+1):
            tempskip = skip
            skip = max(skip,take)
            take = tempskip + dp[i]
        return max(skip,take)

        