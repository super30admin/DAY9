# Time : O(n)
# Space: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        arr = [0] * (max(nums) + 1)
        dp = arr.copy()
        for num in nums:
            arr[num] += 1
        for num in range(len(arr)-1, -1, -1):
            if num == len(arr)-1:
                dp[num] += num*arr[num]
            else:
                if num+2 < len(arr):
                    dp[num] = max(dp[num+1], arr[num]*num + dp[num+2])
                else:
                    dp[num] = max(dp[num+1], arr[num]*num)
        return dp[1]