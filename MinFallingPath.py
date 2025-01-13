# Time complexity O(n^2)
# Space complexity O(1)

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        for i in range(n-2, -1, -1):
            for j in range(0,n):
                if j == 0:
                    matrix[i][j] = matrix[i][j]+ min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
        min1 = float('inf')
        for j in range(n):
            min1 = min(min1, matrix[0][j])
        
        return min1
