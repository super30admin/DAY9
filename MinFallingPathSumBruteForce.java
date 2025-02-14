// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Time: O(Exponential)
// Space: O(N) --> Recursive stack space
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Try out all possible ways: left, down, right


class Solution {
    // Exhaustive - Recursive
    // Time: O(Exponential)
    // Space: O(N) --> Recursive stack space

    int mini;
    private void exhaustive(int[][] matrix, int currRow, int prevChoice, int currSum){
        //Base
        if(currRow==matrix.length){
            // reached bottom of matrix
            mini = Math.min(mini, currSum);
            return;
        }
        
        //Logic
        //Recur by chosing all elements(left, down, right) of a row, if in bounds
        //left
        if(prevChoice>=1)   exhaustive(matrix, currRow+1, prevChoice-1, currSum+matrix[currRow][prevChoice - 1]);
        //down
        exhaustive(matrix, currRow+1, prevChoice, currSum+matrix[currRow][prevChoice]);
        //right
        if(prevChoice+1<matrix[0].length)   exhaustive(matrix, currRow+1, prevChoice+1, currSum+matrix[currRow][prevChoice+1]);
    }

    public int minFallingPathSum(int[][] matrix) {
        mini = Integer.MAX_VALUE;

        //for loop to cover first row
        for(int i=0;i<matrix[0].length;i++){
            exhaustive(matrix, 0, i, 0);
        }
        return mini;
    }
}