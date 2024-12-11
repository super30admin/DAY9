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
