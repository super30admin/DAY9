'''
Time complexity: O(n^2)
Space complexity: O(n) where n is the number of columns in the matrix
Did this code successfully run on Leetcode : Yes(#931)
Any problem you faced while coding this : No
Approach:
- Failling def -> dp[i][j] = matrix[i][j] + min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])
- We can optimize the space complexity by using only 1D array dp[j] = matrix[i][j] + min(dp[j-1],dp[j],dp[j+1])
- We can use tmp_dp to avoid overridding of values
'''

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = matrix[0][:]
        for row in range(1,len(matrix)):
            tmp_dp = [0] * len(matrix[0]) # use this to avoid overridding of values
            for col in range(len(matrix[0])):
                if col-1 >=0 and col+1 <= len(matrix[0])-1:
                    min_val = min(dp[col-1],dp[col],dp[col+1])
                else:
                    if col-1 >=0: # first column
                        min_val = min(dp[col-1],dp[col])
                    else: # last column
                        min_val = min(dp[col],dp[col+1])  
                tmp_dp[col] = matrix[row][col] + min_val
            dp = tmp_dp
        return min(dp)
    

#Driver code
sol = Solution()
print(sol.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]])) # 13