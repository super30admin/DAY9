class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0] * m for _ in range(n)]

        for j in range(m):
            dp[0][j] = matrix[0][j]

        for i in range(1, n):
            for j in range(m):
                ld = rd = float('inf')
                up = matrix[i][j] + dp[i - 1][j]

                if j - 1 >= 0:
                    ld = matrix[i][j] + dp[i - 1][j - 1]
                if j + 1 < m:
                    rd = matrix[i][j] + dp[i - 1][j + 1]

                dp[i][j] = min(up, min(ld, rd))

        mini = dp[n - 1][0]
        for j in range(1, m):
            mini = min(mini, dp[n - 1][j])
        return mini

#time - o(m*n)
# space - o(m*n)