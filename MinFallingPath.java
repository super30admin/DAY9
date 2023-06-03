// Time Complexity : O(N*N) -- N is the number of rows and columns of matrix
// Space Complexity : O(N*N) -- N is the number of rows and columns of matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to look for the development of pattern discussed for the house-paint-cost problem


// Your code here along with comments explaining your approach
/* Approach -
 * Generalised the House Paint problem by taking the for loop for number of columns, as the number of columns is dynamic along with the 
 * number of rows.
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            dp[matrix.length-1][j] = matrix[matrix.length-1][j];
        }
        
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]); 
                }else if(j==matrix[0].length-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
                
            }
        }
        int min = matrix[0][0];
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min,matrix[0][i]);
        }

        return min;

    }

    
}