// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
// (https://leetcode.com/problems/minimum-falling-path-sum/)

// Algo: similar to house coloring problem 

import java.util.Arrays;

public class MinFallingPathSum_LC_931 {
    /**
     * TC: exponential: O(3^n)
     * SC: O(n)
     * 
     * @param matrix
     * @return
     */
    public int minFallingPathSum_recursion(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for (int c = n - 1; c >= 0; c--) {
            min = Math.min(min, minSum_recursion(matrix, n - 1, c));
        }
        return min;
    }

    private int minSum_recursion(int[][] matrix, int r, int c) {
        int n = matrix.length;
        // base
        if (c < 0 || c >= n) {
            return Integer.MAX_VALUE;
        }
        if (r == 0) {
            return matrix[r][c];
        }
        // logic
        int left = minSum_recursion(matrix, r - 1, c - 1);
        int up = minSum_recursion(matrix, r - 1, c);
        int right = minSum_recursion(matrix, r - 1, c + 1);
        int min = Math.min(left, Math.min(up, right));
        if (min != Integer.MAX_VALUE) {
            min += matrix[r][c];
        }
        return min;
    }

    /**
     * TC: exponential: O(n^3)
     * SC: O(n^2) + O(n)
     */
    public int minFallingPathSum_memoize(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        for (int c = n - 1; c >= 0; c--) {
            min = Math.min(min, minSum_memoize(matrix, n - 1, c, dp));
        }
        return min;
    }

    private int minSum_memoize(int[][] matrix, int r, int c, int[][] dp) {
        int n = matrix.length;
        // base
        if (c < 0 || c >= n) {
            return Integer.MAX_VALUE;
        }
        if (r == 0) {
            return matrix[r][c];
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        // logic
        int left = minSum_memoize(matrix, r - 1, c - 1, dp);
        int up = minSum_memoize(matrix, r - 1, c, dp);
        int right = minSum_memoize(matrix, r - 1, c + 1, dp);
        int min = Math.min(left, Math.min(up, right));
        if (min != Integer.MAX_VALUE) {
            min += matrix[r][c];
        }
        return dp[r][c] = min;
    }

    /**
     * TC: exponential: O(n^2)
     * SC: O(n^2)
     */
    public int minFallingPathSum_tabulation(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int left = c - 1 < 0 ? Integer.MAX_VALUE : dp[r - 1][c - 1];
                int up = dp[r - 1][c];
                int right = c + 1 >= n ? Integer.MAX_VALUE : dp[r - 1][c + 1];
                min = Integer.MAX_VALUE;
                min = Math.min(left, Math.min(up, right));
                if (min != Integer.MAX_VALUE) {
                    min += matrix[r][c];
                }
                dp[r][c] = min;
            }

        }
        min = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            min = Math.min(min, dp[n - 1][c]);
        }
        return min;
    }

    /**
     * TC: exponential: O(n^2)
     * SC: O(n)
     */
    public int minFallingPathSum_spaceOptimization(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int c = 0; c < n; c++) {
            dp[c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {
            int[] curr = new int[n];
            for (int c = 0; c < n; c++) {
                int left = c - 1 < 0 ? Integer.MAX_VALUE : dp[c - 1];
                int up = dp[c];
                int right = c + 1 >= n ? Integer.MAX_VALUE : dp[c + 1];
                min = Integer.MAX_VALUE;
                min = Math.min(left, Math.min(up, right));
                if (min != Integer.MAX_VALUE) {
                    min += matrix[r][c];
                }
                curr[c] = min;
            }
            dp = curr;
        }
        min = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            min = Math.min(min, dp[c]);
        }
        return min;
    }

    /**
     * TC: exponential: O(n^2)
     * SC: O(n^2)
     */
    public int[] minFallingPathSum_findPath(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        int[][] mins = new int[n][n];
        int[] path = new int[n];
        int minIndex = 0;

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                minIndex = c - 1;
                int left = c - 1 < 0 ? Integer.MAX_VALUE : dp[r - 1][c - 1];
                int up = dp[r - 1][c];
                if (left > up) {
                    minIndex = c;
                }
                int right = c + 1 >= n ? Integer.MAX_VALUE : dp[r - 1][c + 1];
                if (up > right) {
                    minIndex = c + 1;
                }
                min = Integer.MAX_VALUE;
                min = Math.min(left, Math.min(up, right));
                if (min != Integer.MAX_VALUE) {
                    min += matrix[r][c];
                }
                dp[r][c] = min;
                mins[r][c] = minIndex;
            }

        }
        min = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            if (min > dp[n - 1][c]) {
                min = dp[n - 1][c];
                path[n - 1] = matrix[n - 1][c];
                minIndex = mins[n - 1][c];
            }
        }

        for (int r = n - 2; r >= 0; r--) {
            path[r] = matrix[r][minIndex];
            minIndex = mins[r][minIndex];
        }

        return path;
    }

}