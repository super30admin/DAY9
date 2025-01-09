/*
TimeComplexity =-> O(N*N)
Space complexity -> O(1)
*/

class Problem1 {
    public int minFallingPathSum(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == col - 1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] = matrix[i][j] +
                            Math.min(matrix[i + 1][j - 1], Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}