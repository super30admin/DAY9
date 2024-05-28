// Time Complexity : O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

// logic: Iterate from the second-to-last row upwards, updating each cell with the minimum sum of the falling path possible from the current cell to the next row.
// For each cell, update its value by adding the minimum value among the three possible cells in the next row it can fall to (directly below, diagonally left, or diagonally right).
// After updating the entire matrix, the minimum value in the top row will be the answer.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return -1;
        }

        int n = matrix.length;

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if( j ==0){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if( j == n-1){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1], matrix[i+1][j-1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j =0; j< n; j++){
            min = Math.min(min, matrix[0][j]);
        }

        return min;

    }
}