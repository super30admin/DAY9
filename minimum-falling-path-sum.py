"""

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, 
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13

Example 2:

Input: matrix = [[-19,57],[-40,-5]]
Output: -59

Time Complexity: O(n^2)
Space Complexity: O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# iterated through the matrix row by row, updating each cell with the minimum sum path from the previous row.  
# For each cell, considered three possible paths (left, middle, and right) from the row above and take the minimum value.  
# Finally, returned the minimum value from the last row, which represents the smallest falling path sum.  


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        n = len(matrix)

        for i in range(1, n):
            for c in range(n):
                mid = matrix[i-1][c]
                left = matrix[i-1][c-1] if c > 0 else float("inf")
                right = matrix[i-1][c+1] if c < n - 1 else float("inf")
                
                matrix[i][c] += min(left, mid, right)

        return min(matrix[-1])
