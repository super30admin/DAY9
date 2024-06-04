// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        for(int i =  n - 2; i >=0 ; i--){ // starting from the second last row as we did in colouring problem
            for(int j = 0; j < matrix[0].length; j++){ // iterating the cols
                if(j==0){ // first col
                    matrix[i][j] = matrix[i][j] + Math.min( matrix[i+1][j], matrix[i+1][j+1] ); // we only have access to the first and second col
                }
                else if(j == n - 1){ // last col
                    matrix[i][j] = matrix[i][j] + Math.min( matrix[i+1][j], matrix[i+1][j-1] ); // we only have access to the last and the second last col
                }else{
                    matrix[i][j] = matrix[i][j] + Math.min( matrix[i+1][j], Math.min( matrix[i+1][j+1], matrix[i+1][j-1] )); // any col that is not at any end, so we have access to bottom and its adjacents only
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < matrix.length; k++){
            min = Math.min(min, matrix[0][k]); // looping over the first row to find the minimum
        }
        return min;
    }
}