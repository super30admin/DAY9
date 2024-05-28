# Time Complexity : O(n^2)
# Space Complexity : O(1)

class Solution:
    def minFallingPathSum(self, matrix):
        if not matrix or len(matrix) == 0:
            return 0
        
        n = len(matrix)
        for i in range(n - 2, -1, -1):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == n - 1:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j - 1])
        
        return min(matrix[0])

# Example 1
solution = Solution()
matrix = [
    [2, 1, 3],
    [6, 5, 4],
    [7, 8, 9]
    ]
print(solution.minFallingPathSum(matrix))  # Output: 13

# Example 2
matrix = [
    [-19,57],
    [-40,-5]
    ]
print(solution.minFallingPathSum(matrix))  # Output: -59

# Example 2
matrix = [
    [22, 98, 66],
    [23, 5, 14],
    [7, 8, 9]
    ]
print(solution.minFallingPathSum(matrix))  # Output: 34