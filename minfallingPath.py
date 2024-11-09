"""
TC: O(n) n^2: iterate through n*n matrix
SP:O(1) No additional space
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                left = matrix[i-1][j]
                down = matrix[i-1][j+1] if j+1 < len(matrix) else float('inf')
                right = matrix[i-1][j-1] if j >0 else float('inf')
                matrix[i][j] = matrix[i][j] + min(left, down, right)
        return min(matrix[-1])