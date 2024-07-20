//Dynamic Programming

//Time, Space = O(n^2)
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // get the size of the matrix
        int n = matrix.length;
        // create a new 2D array to store the minimum path sum for each element
        int[][] dp = new int[n][n];

        // initialize the first row of the dp array to the values in the first row of the matrix
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // loop through the remaining rows of the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // initialize the minimum path sum to the value above the current element
                int minPathSum = dp[i - 1][j];
                // check if the path sum to the left and above is smaller
                if (j > 0) {
                    minPathSum = Math.min(minPathSum, dp[i - 1][j - 1]);
                }
                // check if the path sum to the right and above is smaller
                if (j < n - 1) {
                    minPathSum = Math.min(minPathSum, dp[i - 1][j + 1]);
                }
                // add the current element to the minimum path sum and store it in the dp array
                dp[i][j] = minPathSum + matrix[i][j];
            }
        }

        // find the minimum path sum in the last row of the dp array
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }

        // return the minimum path sum
        return minPathSum;
    }
}










//Brute Force (Exceeds time limit)

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // get the size of the matrix
        int n = matrix.length;
        // call the helper function with starting positions in the first row
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dfs(matrix, 0, i, 0));
        }
        // return the minimum path sum found
        return minPathSum;
    }

    private int dfs(int[][] matrix, int row, int col, int pathSum) {
        // check if the current position is out of bounds
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix.length) {
            return Integer.MAX_VALUE;
        }
        // add the current element to the path sum
        pathSum += matrix[row][col];
        // if we are at the last row, return the path sum
        if (row == matrix.length - 1) {
            return pathSum;
        }
        // find the minimum path sum from the next row
        int minPathSum = Integer.MAX_VALUE;
        minPathSum = Math.min(minPathSum, dfs(matrix, row + 1, col - 1, pathSum));
        minPathSum = Math.min(minPathSum, dfs(matrix, row + 1, col, pathSum));
        minPathSum = Math.min(minPathSum, dfs(matrix, row + 1, col + 1, pathSum));
        // return the minimum path sum found
        return minPathSum;
    }
}
