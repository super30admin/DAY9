class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        N = len(matrix)

        for r in range(1, N):
            for c in range(N):
                m = matrix[r - 1][c]
                l = matrix[r - 1][c - 1] if c > 0 else float("inf")
                r = matrix[r - 1][c + 1] if c < N - 1 else float("inf")
                matrix[r][c] += min(m, l, r)
        return min(matrix[-1])
    # T: O(n**2), S: O(1)