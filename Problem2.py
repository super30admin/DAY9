class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        m = n = len(matrix)
        dp = [[0]*m for _ in range(n)]
        res = float("inf")
        
        for i in range(m):
            dp[m-1][i] = matrix[m-1][i]
        
        for i in range(m-2, -1, -1):
            for j in range(m):
                if j-1 < 0:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j],dp[i+1][j+1])
                elif j+1 >= m :
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j])
                    
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j],dp[i+1][j+1])
        
        for i in range(n):
            res = min(res, dp[0][i])
        return res
        