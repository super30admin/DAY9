# TC: O(n^2)
# SC: O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j == (len(matrix[0]) - 1):
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                elif j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1])
            
            
        return min(matrix[0])
            
