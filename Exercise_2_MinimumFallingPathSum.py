# Time Complexity :

# O(N^2) , N = no. of rows/no. of cols


# Space Complexity :  

# O(1) , Since we are updating the input array itself.


# Approach:
# We use Dynamic Programming to solve this problem,just like paint house problem.
# ===> The idea is to follow bottom-up approach, since we have to return the answer which has minimum 
#      path from top row element to bottom row element.
# ===> I choose the approach to update the input array itself in place, sinceafter iterating through all rows from 
#      second-last row to the topmost row, we would have updated the elements using the constraint asked in the problem.




class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix or len(matrix)==0:
            return 0

        cols = len(matrix[0])
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(0, cols):
                if j==0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])

                elif j == cols-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
                
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])


        minVal = 9999999

        for j in range(0,cols):
            minVal = min(minVal, matrix[0][j])
        
        return minVal