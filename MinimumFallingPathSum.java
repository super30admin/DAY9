//Time complexity - O(N^2)
//Space complexity - O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// We are using 2 dimensional array
// We can reduce space using one dimensional array
class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int row=n-1;row >=0;row--) {
            for(int col=0;col<n;col++) {
                if(col==0) {
                    dp[row][col] = Math.min(dp[row+1][col], dp[row+1][col+1]) + matrix[row][col];
                }else if(col == n-1) {
                    dp[row][col] = Math.min(dp[row+1][col], dp[row+1][col-1]) + matrix[row][col];
                }else{
                    dp[row][col] = Math.min(dp[row+1][col], Math.min(dp[row+1][col+1], dp[row+1][col-1])) + matrix[row][col];
                }
            }
        }

        int minFallingSum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            minFallingSum = Math.min(minFallingSum, dp[0][i]);
        }
        return minFallingSum;
    }
}