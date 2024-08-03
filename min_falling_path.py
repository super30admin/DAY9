#Approach: same as paint house 
# the only difference is logic here we want min in same col or adjacent
# TC:O(n*m)
# SC:O(n*m)n: no of elements in row, m: no of elements in column
#bottom to up
#first store the bottom most in dp
#then in a row above store min of same col or diagonal 
#check for first and last column especially because for left it can check for just below and right diagonal
#for last column in any row it will only check for just below and left diagonal 



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n=len(matrix)
        m=len(matrix[0])
        if n == 0:
            return 0
        dp=[[0]* m for _ in range(n)]
        for j in range(m):
            dp[n-1][j] = matrix[n-1][j]
        

        for i in range(n-2,-1,-1):
            for j in range(m):

                if j==0:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])

                elif j==m-1:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])

                else:
                    dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1],dp[i+1][j-1])

        return min(dp[0])
