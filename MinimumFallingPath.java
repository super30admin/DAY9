/**
 * Time Complexity: O(n * m)
 * - n is the number of rows and m is the number of columns in the matrix.

 * Space Complexity: O(1)
 * - Only a few extra variables are used for computation.
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int matrixLength = matrix.length;
        int matrixCols = matrix[0].length;

        for(int i = matrixLength - 2; i >= 0; i--) {
            for(int j = 0; j < matrixCols; j++) {
                int minValue = matrix[i + 1][j];
                if(j == 0) {
                    minValue = Math.min(minValue, matrix[i + 1][j + 1]);
                }
                if(j > 0 && j < matrixCols - 1) {
                    minValue = Math.min(minValue, Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
                if(j == matrixCols - 1) {
                    minValue = Math.min(minValue, matrix[i + 1][j - 1]);
                }
                matrix[i][j] += minValue;
            }
        }

        int minValue = matrix[0][0];
        for(int i = 1; i < matrixCols; i++) {
            minValue = Math.min(minValue, matrix[0][i]);
        }

        return minValue;
    }
}
