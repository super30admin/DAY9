//TC:O(n²) n × n matrix
//SC:O(1)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
          int n = matrix.length;
        
        // Bottom-up DP (Modify matrix in place)
        for (int i = n - 2; i >= 0; i--) { // Start from second last row
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int leftDiag = (j > 0) ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int rightDiag = (j < n - 1) ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                
                matrix[i][j] += Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }
        
        // The minimum value in the first row is the answer
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[0][j]);
        }
        
        return minSum;
    }
    
}