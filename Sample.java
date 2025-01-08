// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Time complexity:O(n^2)
// Space complexity:O(1)

// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result=0;

        for (int i=n-2;i>=0;i--) {
            for (int j=0;j<matrix[i].length;j++) {
                if(j==0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j+1]);
                }
                else if (0<j && j<matrix[i].length-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j] , matrix[i+1][j+1]));
                } 
                else if(j==matrix[i].length-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1] , matrix[i+1][j]);
                }
            }
        }


        for (int i=matrix[0].length-2;i>=0;i--){
            matrix[0][i] = Math.min(matrix[0][i], matrix[0][i+1]);
        }
        

        return matrix[0][0];
        
    }
}
