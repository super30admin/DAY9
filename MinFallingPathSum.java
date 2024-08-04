//TC: O(n^2)
//OC: O(n^2)
//Approach: dp[i][j] represents the minimum sum obtained by choosing the index i,j element. calculate min sum by taking min value of adjacent elements present at the previous row. Have conditional check for EDGE cases.  

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        
        int[][] dp = new int[n+1][n];

        //O(n^2)
        for(int i=1;i<=n;i++){
            for(int j=0;j<n;j++){
                if(j==0)
                    dp[i][j] = matrix[i-1][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==n-1)
                    dp[i][j] = matrix[i-1][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);
                else
                    dp[i][j] = matrix[i-1][j] + Math.min(dp[i-1][j+1] ,Math.min(dp[i-1][j-1],dp[i-1][j]));
            }
        }

        //O(nLogN)
        Arrays.sort(dp[n]);
        
        return dp[n][0];
    }
}