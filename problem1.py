#Delete and Earn
#TC:O(N)
#SC:O(N)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        maxx =0
        for num in nums:
            maxx = max(maxx,num)
        dp = [0]*(maxx+1)
        for num in nums:
            dp[num]+=num
        skip=0
        take = dp[0]
        for i in range(len(dp)):
            temp = skip
            skip = max(skip,take)
            take = temp+dp[i]
        return max(skip,take)