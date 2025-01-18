# Used a bottom up approach and for edges we've added the two of the columns and for other columns we've found minimum of all three possible columns
# TC: O(n^2)
# SC: O(1)
# Yes, this worked in leetcode


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        n = len(matrix)
        for i in range(n - 2, -1, -1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == n - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j - 1])
        minimum = 100000  # Since the constraints were given in the question or we can use "inf"
        for k in range(n):
            minimum = min(minimum, matrix[0][k])
        return minimum
