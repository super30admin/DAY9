// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// calculate minimum sum from bottom of matrix by considering 3 conditions
// 1) first column, 2) last column, 3) in between column
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int n = matrix.length;
        for(int i = n-2; i>=0; i--){
            for(int j =0; j<n; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j+1]);
                }
                else if(j== n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j] , Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int j =0 ; j<n; j++){
            res = Math.min(res, matrix[0][j]);
        }

        return res;
    }
}