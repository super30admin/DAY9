# dp[i][j] = minimum path sum from top row to matrix[i][j]

# tc O(n^2), sc O(n).
n = len(matrix)
dp = [[0 for _ in range(n)] for _ in range(2)]
for column in range(n):
    dp[0][column] = matrix[0][column]

for row in range(1, n):
    for column in range(n):
        if column == 0:
            dp[row%2][column] = matrix[row][column] + min(dp[(row-1)%2][column], dp[(row-1)%2][column+1])
        elif column == n-1:
            dp[row%2][column] = matrix[row][column] + min(dp[(row-1)%2][column], dp[(row-1)%2][column-1])
        else:
            dp[row%2][column] = matrix[row][column] + min(dp[(row-1)%2][column], dp[(row-1)%2][column-1], dp[(row-1)%2][column+1])

return min(dp[(n-1)%2])