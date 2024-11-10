/*
Time complexity: The time complexity of this solution is O(m * n), where:

                m is the number of rows in the matrix (matrix.length).
                n is the number of columns in the matrix (matrix[0].length).

Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
 */

class MinimuFallingPathSumDPMatrix {
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][]dp = new int[m][n];

        // Fill the last row of dp with the values from the last row of the matrix
        for (int j = 0; j < n; j++) {
            dp[m-1][j] = matrix[m-1][j];
        }

        // Fill the dp array from bottom to top
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                // For the first column
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                // For the last column
                else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }
                // For the middle columns
                else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                }
            }
            /*
            Dynamic Initialization of Last Row:

            Instead of manually setting dp[m-1][0], dp[m-1][1], and dp[m-1][2], we now fill the last row dp[m-1][j]
            with the values from the matrix’s last row using a loop. This makes the solution work for any number of
            columns.

            Loop Over All Columns:

            The main loop to fill dp[i][j] now dynamically handles all columns. We use conditional statements to
            handle:
            The first column (j == 0) where the only valid previous elements are dp[i+1][j] (directly below) and
            dp[i+1][j+1] (diagonally right).
            The last column (j == n-1) where the valid previous elements are dp[i+1][j-1] (diagonally left) and
            dp[i+1][j] (directly below).
            All other middle columns (0 < j < n-1) where the valid previous elements are dp[i+1][j-1], dp[i+1][j],
            and dp[i+1][j+1].

            Final Answer:

            The final answer is computed by returning the minimum value from the first row of the dp table
             */
        }

        // Return the minimum value in the first row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[0][j]);
        }

        return minPathSum;
    }
}