# Explain your approach in three sentences only at top of your code
# Approach: Use dynamic programming to compute the minimum falling path sum by updating each element in the matrix
# to store the minimum path sum to reach that element from the top row. For each element, add the minimum of the three 
# possible elements from the previous row (directly above, top-left, and top-right) to accumulate the minimum path sum.

# Time Complexity: O(n^2), where n is the size of the matrix, as we iterate over each element in the matrix once.
# Space Complexity: O(1), as we modify the matrix in place without additional space.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        
        # Start from the second-to-last row and move upwards
        for row in range(n - 2, -1, -1):
            for col in range(n):
                # Get the minimum path sum from the row below
                min_below = matrix[row + 1][col]  # directly below
                if col > 0:
                    min_below = min(min_below, matrix[row + 1][col - 1])  # bottom-left
                if col < n - 1:
                    min_below = min(min_below, matrix[row + 1][col + 1])  # bottom-right
                
                # Update the current cell with the min falling path sum
                matrix[row][col] += min_below

        # The result is the minimum path sum starting from any element in the top row
        return min(matrix[0])
