"""
931. Minimum Falling Path Sum
Brute force approach --
Greedy
Choose/not choose which gives time limit exceeded since repeated sub problems cause exponential time complexity

Optimized DP Bottom up approach --
1. we leave the last row as it is
2. start from the second last row. while selecting the minimum element from the row below for the 0th col and for the
n-1 col, the valid nums are (row+1, col), (row+1, col+1) AND (row+1, col), (row+1, col-1) respectively
3. Continue bottom up till we reach the 0th row
4. Return the minimum

TC - O(n * n)
SC - O(n * n) IF we need to cannot mutate the provided matrix and need to create a duplicate matrix
If the interviewer allows mutating the same matrix SC = O(1)
"""
import math

matrix = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]


def minFallingPathSum(m):
    if m is None or len(m) == 0: return 0

    n = len(m)

    # since starting from second last row
    for i in range(n - 2, -1, -1):
        for j in range(n):
            # if 0th col
            if j == 0:
                m[i][j] = m[i][j] + min(m[i + 1][j], m[i + 1][j + 1])
            # if last col
            elif j == n - 1:
                m[i][j] = m[i][j] + min(m[i + 1][j], m[i + 1][j - 1])
            else:
                m[i][j] = m[i][j] + min(m[i + 1][j - 1], m[i + 1][j], m[i + 1][j + 1])

    minVal = math.inf

    for j in range(n):
        minVal = min(minVal, m[0][j])

    return minVal


if __name__ == '__main__':
    print(minFallingPathSum(matrix))
