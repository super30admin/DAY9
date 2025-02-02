# Problem 25: (https://leetcode.com/problems/minimum-falling-path-sum/)

#Time Complexity : O(mn)
# Space Complexity :O(mn)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

#similar to the paint house question
# just needed to ad the loop as the columns are not definite

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix) # no of rows
        n = len(matrix[0]) # no of cols
        dp = [[0] * n for _ in range(m)]

        for j in range (n):
            dp[m-1][j] = matrix[m-1][j]
                
        for i in range(m-2,-1,-1):
            
            for j in range (n):
                if (j == 0):
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j+1])
                elif (j == n-1):
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j-1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], min(dp[i+1][j-1],dp[i+1][j+1]))
        print(dp)
        ans = sys.maxsize
        for j in range(n):
            ans = min(ans,dp[0][j])
        return ans
            
        
