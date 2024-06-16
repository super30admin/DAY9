# Time = O(n)
# Space = O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix is None and matrix[0] is None:
            return -1 
        n = len(matrix)
        for i in range(n-2, -1, -1):
            for j in range(n):
                if j == 0:
                    # left and right
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j+1],min(matrix[i+1][j-1], matrix[i+1][j]))
        min_value = matrix[0][0]
        for i in range(1,n):
            min_value = min(max_value, matrix[0][i])
        return min_value



        