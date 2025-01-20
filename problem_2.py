def minFallingPathSum(matrix):
    m = len(matrix)
    n = len(matrix[0])
    dp = matrix.copy()
    # Go bottom up
    for i in range(m-2, -1, -1):
        for j in range(n):
            if j == 0:
                dp[i][j] += min(dp[i+1][j], dp[i+1][j+1])
            elif j == n -1:
                dp[i][j] += min(dp[i+1][j], dp[i+1][j-1])
            else:
                dp[i][j] += min(dp[i+1][j], dp[i+1][j-1], dp[i+1][j+1])
    

    return min(dp[0])
