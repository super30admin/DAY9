class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # TC: O(n*n)
        # SC: O(1)
        if matrix is None or len(matrix) == 0:
            return 0
        n = len(matrix)
        
        for i in range(n-2,-1,-1):
            for j in range(0,n):
                # first col
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j+1])
                # last col
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j-1])
                # middle colums
                else:
                    matrix[i][j] += min(matrix[i+1][j],min(matrix[i+1][j+1],matrix[i+1][j-1]))
        return min(matrix[0])


        