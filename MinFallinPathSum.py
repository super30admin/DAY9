#Time complexity: O(m*n) ; m-> number of rows - 1 ; n -> number of cols
#Space complexity: O(1) 
#Leetcode: Yes

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                min_val = float('inf')
                if j > 0:
                    min_val = min(min_val, matrix[i + 1][j - 1])
                min_val = min(min_val, matrix[i + 1][j])
                if j < len(matrix[0]) - 1:
                    min_val = min(min_val, matrix[i + 1][j + 1])
                matrix[i][j] += min_val

        return min(matrix[0])
