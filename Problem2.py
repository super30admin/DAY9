# 931. Minimum Falling Path Sum
#Attempt 1: 2d dp array
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = m

        dp = [[0 for _ in range(n)] for _ in range(m)]

        dp[0] = matrix[0]

        for i in range(1, m):
            for j in range(0, n):
                if j == 0:
                    dp[i][j] = min( (matrix[i][j] + dp[i-1][j]), (matrix[i][j] + dp[i-1][j+1]) )
                elif j == n-1:
                    dp[i][j] = min( (matrix[i][j] + dp[i-1][j]), (matrix[i][j] + dp[i-1][j-1]) )
                else:
                    dp[i][j] = min( (matrix[i][j] + dp[i-1][j]), (matrix[i][j] + dp[i-1][j-1]), (matrix[i][j] + dp[i-1][j+1]) )

        return min(dp[-1])


        