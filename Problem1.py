# 740 Delete and Earn
#Using tabulation
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_ = max(nums)
        arr = [0 for _ in range(max_ + 1)]

        for num in nums:
            arr[num] += num

        dp = [0 for _ in range(len(arr))]

        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])

        for i in range(2, len(arr)):
            dp[i] = max(dp[i-1], arr[i]+dp[i-2])

        return dp[-1]

#Using memoization
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_ = max(nums)
        arr = [0 for _ in range(max_ + 1)]

        for num in nums:
            arr[num] += num
            
        def getMax(arr, i,dp):
            #base case
            if i == 0:
                return arr[i]
            elif i<0:
                return 0

            if dp[i] != -1: return dp[i]

            #logic
            take = arr[i] + getMax(arr,i-2,dp)
            notTake = getMax(arr, i-1,dp)

            dp[i] = max(take,notTake)
            return max(take,notTake)

        n = len(arr)
        dp = [-1 for _ in range(n)]
        return getMax(arr, n-1,dp)

        
            

            

        

        
        