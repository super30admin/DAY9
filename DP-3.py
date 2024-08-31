# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        Max = 0
        for i in range(len(nums)):
            Max = max(Max,nums[i])
        dp = [0 for i in range(Max+1)]
        for i in range(len(nums)):
            idx = nums[i]
            dp[idx] = dp[idx] + idx
        skip =0
        take = dp[0]
        for i in range(1, Max+1):
            tempSkip = skip
            skip = max(skip,take)
            take = tempSkip + dp[i]
        return max(skip, take)
        

## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        n = len(matrix)
        for i in range(n-2,-1,-1):
            for j in range(n):
                if j==0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
        Min = int(sys.maxsize)
        for j in range(n):
            Min = min(Min, matrix[0][j])
        return Min
# TC = O(n^2) ; SC = O(1)