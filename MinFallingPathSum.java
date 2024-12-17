/*
    Leetcode problem 931: Minimum Falling Path Sum
    T.C: O(n * n) :: S.C: O(n * n)

    Solved using DP approach: Initialize a DP matrix of size n * n and
    fill bottom row with the elements of bottom row of given matrix.
    Start filling the dp array from the second last row by adding the
    current element at [i][j] position in matrix and the min directly 
    below or diagonally left/right in the dp matrix. Finally the result
    will be present in the first row of the dp matrix.
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {        
        int n = matrix.length;

        if (matrix == null || n == 0) return 0;
        
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}