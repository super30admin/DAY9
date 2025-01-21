// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // Create a dp array to store minimum sums
        int[][] dp = new int[n][n];

        // Initialize the first row of dp with the first row of the matrix
        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        // Fill the dp array row by row
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int minAbove = dp[row - 1][col]; // Directly above
                if (col > 0) {
                    minAbove = Math.min(minAbove, dp[row - 1][col - 1]); // Diagonally left
                }
                if (col < n - 1) {
                    minAbove = Math.min(minAbove, dp[row - 1][col + 1]); // Diagonally right
                }
                dp[row][col] = matrix[row][col] + minAbove;
            }
        }

        // Find the minimum value in the last row of dp
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, dp[n - 1][col]);
        }

        return minSum;
    
    }
    
}
