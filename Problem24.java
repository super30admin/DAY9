// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// Minimum Falling Path Sum

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        
        // DP table initialization
        int[][] dp = new int[n][n];
        
        // Initialize the first row of dp with the first row of matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        
        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Directly below
                int minPath = dp[i-1][j];
                
                // Diagonally left
                if (j > 0) {
                    minPath = Math.min(minPath, dp[i-1][j-1]);
                }
                
                // Diagonally right
                if (j < n - 1) {
                    minPath = Math.min(minPath, dp[i-1][j+1]);
                }
                
                // Update dp[i][j] with the minimum falling path sum
                dp[i][j] = matrix[i][j] + minPath;
            }
        }
        
        // Find the minimum value in the last row
        int minFallingPathSum = dp[n-1][0];
        for (int j = 1; j < n; j++) {
            minFallingPathSum = Math.min(minFallingPathSum, dp[n-1][j]);
        }
        
        return minFallingPathSum;
    }
}
