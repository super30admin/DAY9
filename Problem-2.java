// Time Complexity : O(n^2))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

public class Problem-2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        //start filling up the matrix with least path from n-2 row
        for(int i = n -2; i >= 0; i-- ){
            for(int j = 0; j < n; j++){
                //bound check
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == n -1 ){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else{
                    // chose 3 elements
                    matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i+1][j], matrix[i+1][j+1]), matrix[i+1][j-1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        //iterate over the first row to find the min value
        for(int i = 0; i < n; i++){
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}
