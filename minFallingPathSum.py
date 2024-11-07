# // Time Complexity : 
# // Space Complexity :
# // Did this code successfully run on Leetcode :No
# // Any problem you faced while coding this : Initial row op is wrong


# // Your code here along with comments explaining your approach
# Create a dp array. Initialize 1st row. add left ,right and regular case.
# find min of dp array
class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        m, n = len(matrix), len(matrix[0])

        dp = matrix[0][:] # dp array

        for i in range(1,m):
            
            for j in range(n):
                if j == 0:                      #left case
                    dp[j] = matrix[i][j] + min(dp[j], dp[j+1])
                elif j == n - 1:                #right case
                    dp[j] = matrix[i][j] + min(dp[j-1], dp[j])
                else:                           #regular case
                    dp[j] = matrix[i][j] + min(dp[j-1], dp[j], dp[j+1])
        return min(dp)                          #shortest path
    

print(Solution().minFallingPathSum([[-19,57],[-40,-5]]))