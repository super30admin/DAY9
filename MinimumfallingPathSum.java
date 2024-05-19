/**

Creating another matrix and storing minimum values using bottom up approach

TC- O(n*m), SC = O(m*n);
 */

 class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer. MAX_VALUE;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int j = 0;j<n;j++){
            dp[m-1][j]=matrix[m-1][j];
        }

        for(int i = m-2;i>=0;i--){
            for(int j=0;j<m;j++){
                
                if(j==0){
                    dp[i][j] = matrix[i][j]+Math.min(
                                dp[i+1][j],dp[i+1][j+1]);
                } else if(j==m-1){
                dp[i][j] = matrix[i][j]+Math.min(
                                dp[i+1][j-1],dp[i+1][j]);
                }
                else{
                 dp[i][j] = matrix[i][j]+Math.min(
                                dp[i+1][j-1],Math.min(dp[i+1][j],dp[i+1][j+1]));
                }
            }
        }
        for(int j = 0; j< n;j++){
            min = Math.min(min, dp[0][j]);
        }
        return min;
    }
}