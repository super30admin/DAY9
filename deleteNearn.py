"""
TC: O(n) n: len(nums)
SP:O(n)  n: len(nums)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        mx = max(nums)
        arr = [0]*(mx+1)
        for n in nums:
            arr[n]+=n
        dp = [0] * (len(arr)+2)
        for i in range (2, len(arr)+2):
            dp[i] = max(dp[i-2]+arr[i-2], dp[i-1])
        return dp[-1]