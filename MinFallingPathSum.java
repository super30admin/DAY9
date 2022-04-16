// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        
        for(int i = matrix.length - 2; i >= 0; i--) {
            for(int j = 0; j < matrix[0].length; j++) {
             
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                } else if( j == matrix[0].length - 1) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1], matrix[i+1][j-1]));

                }
            }
        }
        
        for(int i = 0; i < matrix[0].length; i++) {
            min = Math.min(matrix[0][i], min);
        }
        return min;
    }
}
