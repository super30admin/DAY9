// Time Complexity :O(N*N)
// Space Complexity :O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];

        // Initialize memo array with -1 indicating uncomputed states
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, helper(matrix, 0, i, memo));
        }
        return min;
    }

    private int helper(int[][] matrix, int rowIdx, int colIdx, int[][] memo) {
        // base case
        if (rowIdx == matrix.length - 1) {
            return matrix[rowIdx][colIdx];
        }

        // If this subproblem has already been solved, return the stored result
        if (memo[rowIdx][colIdx] != Integer.MAX_VALUE) {
            return memo[rowIdx][colIdx];
        }

        // logic
        int pick1 = Integer.MAX_VALUE;
        if (colIdx > 0) {
            pick1 = matrix[rowIdx][colIdx] + helper(matrix, rowIdx + 1, colIdx - 1, memo);
        }
        int pick2 = matrix[rowIdx][colIdx] + helper(matrix, rowIdx + 1, colIdx, memo);
        int pick3 = Integer.MAX_VALUE;
        if (colIdx < matrix[0].length - 1) {
            pick3 = matrix[rowIdx][colIdx] + helper(matrix, rowIdx + 1, colIdx + 1, memo);
        }

        // Store the result in memo array and return it
        memo[rowIdx][colIdx] = Math.min(pick1, Math.min(pick2, pick3));
        return memo[rowIdx][colIdx];
    }
}
