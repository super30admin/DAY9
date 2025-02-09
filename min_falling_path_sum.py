# Time complexity - O(n^2) # square matrix
# Space complexity - O(n^2) since I'm maintaining another dp matrix, but can be done in-place (O(1)) 

# Approach - Maintain a dp matrix with first row same as matrix row. Go through the dp array computing min sum
# so far and when come to last row of matrix, update the min value found so far. Return the min.

from typing import List
import sys
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        Min = sys.maxsize
        dp = [[0 for i in range(n)] for j in range(n)]
        for i in range(n):
            dp[0][i] = matrix[0][i]
        
        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    dp[i][j] = min(dp[i-1][j] + matrix[i][j], dp[i-1][j+1] + matrix[i][j])
                elif j == n-1:
                    dp[i][j] = min(dp[i-1][j] + matrix[i][j], dp[i-1][j-1] + matrix[i][j])
                else:
                    dp[i][j] = min(dp[i-1][j-1] + matrix[i][j], dp[i-1][j] + matrix[i][j], dp[i-1][j+1] + matrix[i][j])
                if i == n-1:
                    Min = min(Min, dp[i][j])
        return Min