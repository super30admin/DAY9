// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length - 1;
        int[][] dp = new int[matrix.length + 1][matrix.length + 1];

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n + 1; j++) {
                if (j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                else if (j == n) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i + 1][j - 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }

    // Brute force approach

    // public int minFallingPathSum(int[][] matrix) {
    // int min = Integer.MAX_VALUE;

    // for(int i=0;i<matrix.length;i++) {
    // min = Math.min(min, helper(matrix,0,i,0));
    // }
    // return min;
    // }

    // private int helper(int[][] matrix, int row, int col, int min) {

    // if(row == matrix.length) {
    // return min;
    // }

    // if(col < 0 || col >= matrix.length) {
    // return Integer.MAX_VALUE;
    // }

    // int case1 = helper(matrix, row + 1, col - 1, min + matrix[row][col]);
    // int case2 = helper(matrix, row + 1, col, min + matrix[row][col]);
    // int case3 = helper(matrix, row + 1, col + 1, min + matrix[row][col]);

    // return Math.min(case1, Math.min(case2, case3));
    // }
}