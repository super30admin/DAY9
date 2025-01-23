// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int leftVal  = j - 1 > -1 ? matrix[i+1][j-1] : Integer.MAX_VALUE;
                int rightVal = j + 1 <  n ? matrix[i+1][j+1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min( matrix[i+1][j], Math.min( leftVal , rightVal ) );
            }
        }
        for(int i = 0; i < n; i++ ){
            min = Math.min(min,matrix[0][i]);
        }
        return min;
    }
}
