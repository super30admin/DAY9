def min_falling_path_sum(matrix):
    if not matrix or not matrix[0]:
        return 0

    n = len(matrix)
    dp = matrix[0][:]  

    for i in range(1, n):
        new_dp = [0] * n
        for j in range(n):
            left = dp[j - 1] if j > 0 else float('inf')
            right = dp[j + 1] if j < n - 1 else float('inf')
            new_dp[j] = matrix[i][j] + min(dp[j], left, right)
        dp = new_dp

    return min(dp)

# Time Complexity: O(n^2), where n is the number of rows/columns in the matrix.
# Space Complexity: O(n), as we store only the current and previous rows.
