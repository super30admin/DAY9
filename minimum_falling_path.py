'''
Time Complexity :
O(n*m)
Space Complexity : O(n*m)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''
def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        m,n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(n):
            dp[0][i]=matrix[0][i]

        for i in range(1,m):
            for j in range(n):
                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j+1],dp[i-1][j])
                elif j==n-1:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j-1],dp[i-1][j])
                else:
                    dp[i][j]=matrix[i][j]+min(dp[i-1][j-1],dp[i-1][j+1],dp[i-1][j])

        return min(dp[-1])
