#time = O(n^2)
#space = O(n^2)
def minFallingPathSum(matrix):
    if not matrix or not matrix[0]:
        return 0
    
    n = len(matrix)
    
    # Initialize dp array with the first row of the matrix
    dp = matrix[0][:]
    
    # Iterate through the matrix starting from the second row
    for i in range(1, n):
        new_dp = [0] * n
        for j in range(n):
            min_path = dp[j]
            if j > 0:
                min_path = min(min_path, dp[j-1])
            if j < n - 1:
                min_path = min(min_path, dp[j+1])
            new_dp[j] = matrix[i][j] + min_path
        dp = new_dp
    
    # The result is the minimum value in the last row of the dp array
    return min(dp)

# Example usage
matrix = [
    [2, 1, 3],
    [6, 5, 4],
    [7, 8, 9]
]
print(minFallingPathSum(matrix))  # Output: 13