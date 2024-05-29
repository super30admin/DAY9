# Time Complexity : O(n^2)
# space complexity : O(1)

# Approach :

# start from the second last row and keep comparing the elements in the next row
# for column 0 , we can search arr[i+1][j] and arr[i+1][j+1]
# for the middle columns , we can search arr[i+1][j] and arr[i+1][j+1] and arr[i+1][j-1]
# for last column , we can search arr[i+1][j] and arr[i+1][j-1]

# finally return the minimum sum of the first row in the array

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix)):
                if j == len(matrix)-1:
                    matrix[i][j] = matrix[i][j] + \
                        min(matrix[i+1][j], matrix[i+1][j-1])
                elif j == 0:
                    matrix[i][j] = matrix[i][j] + \
                        min(matrix[i+1][j], matrix[i+1][j+1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1]
                                                      [j-1])

        return min(matrix[0])
