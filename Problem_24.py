# Time Complexity : O(n^2) 
# Space Complexity : O(n^2) for the 2D DP matrix and O(n) for the 1 D implementation
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
#         n = len(matrix)
#         # Given matrix is n*n
#         if not matrix:
#             return
#         dp = [[None for _ in range(n)] for _ in range(n)]
#         for j in  range(n):
#             dp[n-1][j] = matrix[n-1][j] # Initialize the bottom row as same as the matrix
        
#         for i in range(n-2,-1,-1):
#             for j in range(n):
#                 # dp[i][j] will be the matrix cost at matrix[i][j] + the minimum of value in the dp table in the i+1 row and j-1,j and/or j+1 columns for elements diagonally left, directly below and diagonally right to the current element
#                 if j==0:
#                     dp[i][j] = matrix[i][j]+ min(dp[i+1][j],dp[i+1][j+1]) # If j=0, left diagonal can't exist
#                 elif j ==n-1:
#                     dp[i][j] = matrix[i][j]+ min(dp[i+1][j],dp[i+1][j-1]) # If j = n-1, right diagonal can't exist
#                 else:
#                     dp[i][j] = matrix[i][j]+ min(dp[i+1][j-1],dp[i+1][j],dp[i+1][j+1])
                
        
#         return min(dp[0]) # Return whichever path leads to lowest cost

################ O(n) space optimized ######################
        n = len(matrix)
        # Given matrix is n*n
        if not matrix:
            return
        dp = [None for _ in range(n)]
        for j in  range(n):
            dp[j] = matrix[n-1][j] # Initialize dp to same as bottom row of the matrix
        
        for i in range(n-2,-1,-1):
            temp = [None for _ in range(n)] # Create a temp array as val;ue in dp will keep updating
            for j in range(n):
                
                if j == 0:
                    temp[j] = matrix[i][j]+ min(dp[j],dp[j+1]) # If j=0, left diagonal can't exist
                elif j == n-1:
                    temp[j] = matrix[i][j]+ min(dp[j],dp[j-1]) # If j = n-1, right diagonal can't exist
                else:
                    temp[j] = matrix[i][j]+ min(dp[j-1],dp[j],dp[j+1])
            dp = temp # Update dp to the temp array after iteration
                
        
        return min(dp)