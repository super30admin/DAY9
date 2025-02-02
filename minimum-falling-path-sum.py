# Time Complexity : O(n^2) - n is len(matrix)
# Space Complexity : O(n^2) - m is len(matrix)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
This is similar to paint house, but instead of constant no. of colors 3, it is n here
Build a matrix to store the min sum for all possible paths
We can either pick 0th,1st,2nd or (n-1)th number from first row to get the min sum


To store the repeated sub problems, create matrix of n * n
Last row would be same as the input matrix's last row
From second last row, calculate and store the min sum of choosing element in that every column
And keep on doing that till we reach row 0
Min in row 0 will be the answer
"""

def minFallingPathSum(matrix):
    """
    :type matrix: List[List[int]]
    :rtype: int
    """
    n = len(matrix)

    # create matriz same as size as the input matrix
    dp = [[0 for i in range(0, n)] for i in range(0, n)]

    # copy the last row of matrix to dp matrix
    for i in range(0, n):
        dp[n - 1][i] = matrix[n - 1][i]

    # fill the matrix
    for i in range(n - 2, -1, -1):
        for j in range(0, n):
            # if first element, take min of that element and element after that
            if j == 0:
                dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
            # if last element, take min of that element and element before that
            elif j == n - 1:
                dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1])
            # if not corner elements, take min of that element, element after that and element before that
            else:
                dp[i][j] = matrix[i][j] + min(min(dp[i + 1][j - 1], dp[i + 1][j]), dp[i + 1][j + 1])
    return min(dp[0])
