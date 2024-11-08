# // Time Complexity : O(m*n) for matrix traversal
# // Space Complexity :O(n) -> for current matrix and dp array deep copy
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Initial row op was incorrect. needed deep copy.


# // Your code here along with comments explaining your approach
# Create a dp array. Initialize 1st row. add left ,right and regular case.
# find min of dp array
class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        m, n = len(matrix), len(matrix[0])

        dp = matrix[0]  #[2,1,3]

        for i in range(1,m):
            temp = dp[:]                                                #deep copy
            for j in range(n):
                if j == 0:                                              #left case
                    dp[j] = matrix[i][j] + min(temp[j], temp[j+1])
                elif j== n-1:                                           #right case
                    dp[j] = matrix[i][j] + min(temp[j], temp[j-1])
                else:                                                   #regular case
                    dp[j] = matrix[i][j] + min(temp[j+1],temp[j], temp[j-1])

        return min(dp)
    

print(Solution().minFallingPathSum([[-19,57],[-40,-5]]))