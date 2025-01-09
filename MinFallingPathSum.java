// Time Complexity : O ( m x n )
// Space Complexity : O ( 1 ) - reusing input matrix
// Did this code successfully run on Leetcode : Yes

/*
 * go up row-by-row from the second last row
 * for each cell add the min possible value from the available cells below int
 * for the topmost row, also compute the min value of all the row cells
 * and return this value
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) return matrix[0][0];
        int n = matrix.length;
        int i, j;
        int min = Integer.MAX_VALUE;

        for(i = n - 2; i >= 0; i--) {
            for(j = 0; j < n; j++) {
                if (j == 0) matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                else if (j == n - 1) matrix[i][j] += Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);
                else matrix[i][j] += Math.min(Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]), matrix[i + 1][j + 1]);
                if (i == 0) if (min > matrix[0][j]) min = matrix[0][j];
            }
        }
        return min;
    }
}
