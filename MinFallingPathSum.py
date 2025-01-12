class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix)):
                if j==0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j==len(matrix)-1:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])
        