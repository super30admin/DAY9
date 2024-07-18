/*
    1. Time Complexity : O(n * n)
    2. Space Complexity : Memoization - O(n*n), Tabulation - O(1)  
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */
import java.util.Arrays;
class Solution {
    public static int helper(int[][] matrix, int[][] dp, int i, int j, int n) {
        if (j < 0 || j >= n) return 0;
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int res = helper(matrix, dp, i - 1, j,n);
        if (j > 0) res = Math.min(res, helper(matrix, dp, i - 1, j -1,n));
        if (j < n - 1) res = Math.min(res, helper(matrix, dp, i - 1, j + 1, n));
        dp[i][j] = matrix[i][j] + res;
        return dp[i][j];
    }
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; ++j) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            res = Math.min(res, helper(matrix, dp, n - 1, j, n));
        }
        return res;
    }
    public static int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length, min = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {

            for (int j = 0; j < n; ++j) {
                min = matrix[i-1][j];
                if (j > 0) min = Math.min(min, matrix[i-1][j-1]);
                if (j < n - 1) min = Math.min(min, matrix[i-1][j+1]);
                matrix[i][j] += min; 
            }
        }
        min = matrix[n-1][0];
        for (int j = 1; j < n; ++j)
            min = Math.min(min, matrix[n-1][j]);
        return min;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3,5},{6,5,4,9},{7,8,9,6},{2,4,6,1}};
        System.out.println("Using Memoization -- Minimum Falling Path Sum:"+ minFallingPathSum(matrix));
        System.out.println("Using Tabulation  -- Minimum Falling Path Sum:"+ minFallingPathSum2(matrix));
    }
}