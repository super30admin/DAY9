// Problem 931. Minimum Falling Path Sum
// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class MinFallingPathSum {
    public int minFallingPathSum(int[][] m) {
        int n = m.length;
        int dp[][] = new int[n+1][n+1];
        for (int i=n-1; i >= 0; i--) {
            for (int j=0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + m[i][j];
                } else if (j == n-1) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j-1]) + m[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1])) + m[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}
