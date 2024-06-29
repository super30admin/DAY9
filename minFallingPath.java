// Time Complexity : O(mxn) m-rows,n -cols
// Space Complexity : O(mxn) m-rows,n -cols
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp [][] = new int[m][n];
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }else if(j==n-1){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                }else{
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
            }
        }
        int res = dp[m-1][0];
        for(int j=1;j<n;j++){
           res= Math.min(res,dp[m-1][j]);
        }
        return res;
    }
}