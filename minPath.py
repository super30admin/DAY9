# Time Complexity : O(n^2)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 2 for loops throught the matrix in descending order, with element = min of below row
# if element is at c = 0 or c = n-2 then only 2 elements to consider in next row 
def minFallingPathSum(self, matrix: List[List[int]]) -> int:
    n = len(matrix)
    if not matrix or len(matrix) == 0:
        return 0
    for i in range(n-2,-1,-1):
        for j in range(n):
            if j == 0:
                matrix[i][j]= matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
            elif j == n-1:
                matrix[i][j]= matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
            else:
                matrix[i][j]= matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])

    temp = matrix[0]
    return min(temp)