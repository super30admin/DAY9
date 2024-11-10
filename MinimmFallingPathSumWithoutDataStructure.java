/*
Time complexity: The time complexity of this solution is O(m * n), where:

                m is the number of rows in the matrix (matrix.length).
                n is the number of columns in the matrix (matrix[0].length).

Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
 */
class MinimmFallingPathSumWithoutDataStructure {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Start from the second last row and move upwards
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                // Get the minimum of the three possible paths: directly below, diagonally left, diagonally right
                int minPath = matrix[i + 1][j]; // Directly below
                if (j > 0) {
                    minPath = Math.min(minPath, matrix[i + 1][j - 1]); // Diagonally left
                }
                if (j < n - 1) {
                    minPath = Math.min(minPath, matrix[i + 1][j + 1]); // Diagonally right
                }

                // Update the current cell to the minimum path sum
                matrix[i][j] += minPath;
            }
        }

        // The answer will be the minimum value in the top row
        int result = matrix[0][0];
        for (int j = 1; j < n; j++) {
            result = Math.min(result, matrix[0][j]);
        }

        return result;
    }
}

