// Time Complexity :O(N*N)
// Space Complexity :O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // Create a DP array to store minimum path sums
        int[][] dp = new int[n][n];
        
        // Initialize the last row of dp with values from the last row of matrix
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = matrix[n - 1][col];
        }
        
        // Fill the dp array from second last row to the first row
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                // Calculate the minimum path sum for the current cell
                int pick1 = Integer.MAX_VALUE;
                if (col > 0) {
                    pick1 = dp[row + 1][col - 1]; // Pick the left-bottom neighbor
                }
                int pick2 = dp[row + 1][col]; // Pick the bottom neighbor
                int pick3 = Integer.MAX_VALUE;
                if (col < n - 1) {
                    pick3 = dp[row + 1][col + 1]; // Pick the right-bottom neighbor
                }
                // Minimum path sum ending at (row, col) is the matrix value plus the minimum of the three picks
                dp[row][col] = matrix[row][col] + Math.min(pick1, Math.min(pick2, pick3));
            }
        }
        
        // Find the minimum path sum in the first row of dp
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, dp[0][col]);
        }
        
        return minSum;
    }
}
