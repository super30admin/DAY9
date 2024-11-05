# TC: O(m*n)
# SC: O(m*n), but it can be optimized to O(1) if we make changes in the matrix itself
# The code successfully compiled in LC.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = matrix
        for i in range(len(dp)-2, -1, -1):
            for j in range(len(dp[0])):
                if j == 0:
                    dp[i][j] += min(dp[i+1][j], dp[i+1][j+1])
                elif j == len(dp[0]) - 1:
                    dp[i][j] += min(dp[i+1][j-1], dp[i+1][j])
                else:
                    dp[i][j] += min(dp[i+1][j-1], min(dp[i+1][j], dp[i+1][j+1]))
        retVal = float('inf')
        for i in range(len(dp[0])):
            retVal = min(retVal, dp[0][i])
        
        return retVal
