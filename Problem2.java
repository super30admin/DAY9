/* Problem 2: Minimum Falling Path Sum
// Time Complexity : O(N*M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Falls into the same pattern as paint house.
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int result = Integer.MAX_VALUE;
        for(int i = matrix.length - 2; i >= 0; i--){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] += minFromNextRow(matrix, i, j);
            }
        }
        // final sums are at first row so return minimum.
        for(int i = 0; i < matrix.length; i++){
            result = Math.min(result, matrix[0][i]);
        }
        return result;
    }

    private int minFromNextRow(int[][] matrix, int row, int col){
        int min = Integer.MAX_VALUE;
        /* minimum from 3 checks only.*/
        /* 1st check: below*/
        min = Math.min(min, matrix[row + 1][col]);
        /* 2nd check: left diagonal*/
        if(col - 1 >= 0) min = Math.min(min, matrix[row + 1][col - 1]);
        /* 3rd check: right diagonal*/
        if(col + 1 < matrix[0].length) min = Math.min(min, matrix[row + 1][col + 1]);

        return min;

    }
}

//---------------------------------------- Solution 1 ENDS HERE ----------------------------------------