// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int[][] dp = new int[rowLength][colLength];

        for (int i = 0; i < colLength; i++) {
            dp[rowLength - 1][i] = matrix[rowLength - 1][i];
        }

        for (int row = rowLength - 2; row >= 0; row--) {
            for (int col = 0; col < colLength; col++) {
                if (col == 0) {
                    dp[row][col] = matrix[row][col] + Math.min(dp[row + 1][col], dp[row + 1][col + 1]);
                } else if (col == colLength - 1) {
                    dp[row][col] = matrix[row][col] + Math.min(dp[row + 1][col], dp[row + 1][col - 1]);
                } else {
                    dp[row][col] = matrix[row][col] + Math.min(dp[row + 1][col], Math.min(dp[row + 1][col - 1], dp[row + 1][col + 1]));
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}