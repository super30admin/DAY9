# The code defines a method minFallingPathSum to find the minimum falling path sum in a matrix.
# A falling path is a sequence that starts at any element in the first row and moves down to the last row, shifting only to adjacent elements in the row below.

# Setup:
#   - 'n' and 'm' store the number of rows and columns in the matrix.
#   - 'prev' is initialized with the values of the first row, representing the minimum path sums for each element up to that row.

# Dynamic Programming Loop:
#   - Starting from the second row (index 1), we calculate the minimum path sums for each row:
#       - We create a new list 'row' to store the minimum path sums for the current row.
#       - For each column 'j':
#           - The base path sum for row[j] is set to the current element (matrix[i][j]) plus the minimum path sum from the previous row’s same column (prev[j]).
#           - If 'j' > 0 (not the first column), row[j] is updated to consider the diagonal path from the previous row’s left-adjacent element (prev[j-1]).
#           - If 'j' < m - 1 (not the last column), row[j] is updated to consider the diagonal path from the previous row’s right-adjacent element (prev[j+1]).
#       - 'prev' is then set to 'row' to carry the updated path sums to the next row.

# Final Result:
#   - After processing all rows, 'prev' contains the minimum path sums for the last row.
#   - The smallest value in 'prev' is returned, which is the minimum falling path sum for the matrix.

# TC: O(n * m) - Every element in the matrix is processed once.
# SC: O(m) - We use two lists ('prev' and 'row') to store path sums, which scale with the number of columns.


from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        prev = [matrix[0][j] for j in range(m)]
        for i in range(1, n):
            row = [0] * m
            for j in range(m):
                row[j] = prev[j] + matrix[i][j]
                if j > 0:
                    row[j] = min(row[j], prev[j-1] + matrix[i][j])
                if j < m-1:
                    row[j] = min(row[j], prev[j+1] + matrix[i][j])
            prev = row
        return min(prev)