// TC : O(n * n)
// SC : O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix[0].length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], 
                                                           matrix[i-1][j+1]);
                else if(j == n - 1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1], 
                                                           matrix[i-1][j]);
                else
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1],
                                                            Math.min(matrix[i-1][j], 
                                                           matrix[i-1][j+1]));
            }
        }
        for(int j = 0; j < n; j++)
            min = Math.min(min, matrix[m-1][j]);
        return min; 
    }
}
