#TC O(n) + O(max value in array) and SC O(max value in array) 
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0
        Max = 0
        for i in range(len(nums)):
            Max = max(Max, nums[i])
        dp = [0 for i in range(Max + 1)]
        for i in range(len(nums)):
            idx = nums[i]
            dp[idx] = dp[idx] + idx			#Space => O(max value in array) 
        skip = 0
        take = dp[0]
        for i in range(1, Max+1):
            tempskip = skip
            skip = max(skip, take) 
            take = tempskip + dp[i]
        return max(skip,take)



