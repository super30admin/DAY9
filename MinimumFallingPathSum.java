public class MinimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int result = Integer.MAX_VALUE;
            int length = matrix.length;
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    int min = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        min = matrix[i - 1][j - 1];
                    }
                    if (j + 1 < length) {
                        min = Math.min(min, matrix[i - 1][j + 1]);
                    }
                    min = Math.min(min, matrix[i - 1][j]);
                    matrix[i][j] = matrix[i][j] + min;
                }
            }
    
            for (int j = 0; j < length; j++) {
                result = Math.min(result, matrix[length - 1][j]);
            }
    
            return result;
        }
    }
}
