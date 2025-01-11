# Time Complexity : O(n ^ 2), where n is the number of rows/columns in the given square matrix
# Space Complexity : O(1), because we are not using any extra space, just a min variable
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# similar to paint house, we calculate the min of the all possible options using a bottom up approach
# just here there are 2 loops because the number of columns are not fixed
# then we keep adding it to our value at the current indices, and then on the topmost row we compare the min sum path

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """

        if matrix is None:
            return 0
        
        # its a square matrix, so no of rows = no of cols = n
        n = len(matrix)

        # starting from second last row for bottom up approach
        # adding the minimum of all the available path options to the current element
        # and storing the sum path value at the current index in the matrix array
        for i in range(n-2, -1, -1):
            for j in range(n):
                # for the first column
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                
                # for the last column
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
                # for all other columns
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], min(matrix[i+1][j], matrix[i+1][j+1]))

        minimum = float('inf')
        # iterating for the lowest sum value in the first row
        for i in range(n):
            if matrix[0][i] < minimum:
                minimum = matrix[0][i]
        
        return minimum

            

