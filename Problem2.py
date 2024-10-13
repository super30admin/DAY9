# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Minimum Falling Path Sum

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        
        # Traverse from the second-last row to the top
        for i in range(n - 2, -1, -1):
            for j in range(n):
                # Get the possible falling paths
                down = matrix[i + 1][j]
                down_left = matrix[i + 1][j - 1] if j > 0 else float('inf')
                down_right = matrix[i + 1][j + 1] if j < n - 1 else float('inf')

                # Update the current cell with the minimum path sum
                matrix[i][j] += min(down, down_left, down_right)
        
        return min(matrix[0])
        