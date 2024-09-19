# Time/ Space complexity - O(m*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        r = len(matrix)
        c = len(matrix[0])
        if r == 1:
            return min(matrix[0])
                
        min_path = 101
        dp = [[0] * (c) for _ in range(r+1)]
        for i in range(r-1, -1, -1):
            for j in range(0,c):
                print(i,j)
                if j == 0:
                    dp[i][j] = matrix[i][j]  + min(dp[i+1][j], dp[i+1][j+1])
                elif j == c-1:
                    dp[i][j] = matrix[i][j]  + min(dp[i+1][j], dp[i+1][j-1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1])

        return min(dp[0])

