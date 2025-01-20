// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class PathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 0 ||  matrix == null){
            return 0;
        }
        int n = matrix.length;
        for(int i = n-2; i>=0; i--){
            for(int j = 0 ;j<n; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);

                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],matrix[i+1][j+1]);
                }
            }
        }
        int minPathSum = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            minPathSum = Math.min(minPathSum,matrix[0][j]);
        }
        return minPathSum;
    }
}