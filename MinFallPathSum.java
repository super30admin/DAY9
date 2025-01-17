/* Description: Starting from second last row, for each cell, taking the min of accessible elements in the next row and adding the value
to current cell and storing it there. So, at any given x row, we have ans right in x+1 row, we dont have to go to x+2 or x+3 row, we are
getting the min and adding it and storing it there itself. Then final ans will be the min of first row.
 */
// Time Complexity : O(n^2)
// Space Complexity : O(1) (Mutating the original matrix)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // Base case
        if (matrix.length == 0 || matrix == null) {
            return 0;
        }
        int n = matrix.length;
        // Starting from second last row
        for (int i = n - 2; i >= 0; i--) {
            // For all columns since we have n*n matrix
            for (int j = 0; j < n; j++) {
                // When we are at first column, we only have access to the first and second
                // column of next row
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                // When we are at last column, we only have access to the last and second last
                // column of next row
                else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                // When we are anywhere in between, we have access to the j, j+1, j-1 columns in
                // next row
                else {
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        // Returning the min of first row
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}