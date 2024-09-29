""""
Time complexity: O(n^2) and space complexity: O(n^2)
Todo: reduce space to O(n)
"""
from typing import List


class Solution:
    def dp_sol(self, matrix):
        rows = len(matrix)
        cols = len(matrix)
        dp = [[0 for _ in range(cols)] for _ in range(rows)]

        for col in range(cols):
            dp[rows - 1][col] = matrix[rows - 1][col]

        for row in range(rows - 2, -1, -1):
            for col in range(0, cols):
                min_val = dp[row + 1][col]  # Start with the value directly below
                if col > 0:
                    min_val = min(min_val, dp[row + 1][col - 1])  # Consider the left diagonal
                if col < cols - 1:
                    min_val = min(min_val, dp[row + 1][col + 1])  # Consider the right diagonal

                dp[row][col] = min_val + matrix[row][col]

        return dp

    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        dp = self.dp_sol(matrix)
        ans = float("inf")
        for c in range(len(dp)):
            ans = min(ans, dp[0][c])

        return ans
