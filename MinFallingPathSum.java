// Create a DP array of size matrix and fill the array with minimum sums
// TC: O(n2)
// SC: O(n2)
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<n;j++) {
                if(j==0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                } else if(j==n-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],Math.min(dp[i+1][j-1],dp[i+1][j+1]));
                }
            }
        }

        int min = dp[0][0];
        for(int i=1;i<n;i++) {
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }
}

// TC: O(n2)
// SC: O(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--) {
            int prev = dp[0];
            for(int j=0;j<n;j++) {
                int temp = dp[j];
                if(j==0) {
                    dp[j] = matrix[i][j] + Math.min(dp[j],dp[j+1]);
                } else if(j==n-1) {
                    dp[j] = matrix[i][j] + Math.min(dp[j],prev);
                } else {
                    dp[j] = matrix[i][j] + Math.min(dp[j],Math.min(prev,dp[j+1]));
                }
                prev = temp; 
            }
        }

        int min = dp[0];
        for(int i=1;i<n;i++) {
            min = Math.min(min,dp[i]);
        }
        return min;
    }
}