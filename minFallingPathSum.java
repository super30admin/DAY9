
//Similar to paint house but matrix is n*n
//TC: O(n^2)
//SC: O(1)
// Checking 3 cases starting,last, middle cells
class minFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        int n = matrix.length;
        //This nested loop will help fiding all the values of row 0 which we need to pick min in the row 0.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(matrix[0][i], min);
        }
        return min;
    }
}
