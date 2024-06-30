// Time Complexity : O(n^2)
// Space Complexity : O(1) - mutating original matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// With mutation of original matrix
class Solution {
  public int minFallingPathSum(int[][] matrix) {
    // Edge cases
    if(matrix == null || matrix.length == 0) return 0;
    int length = matrix.length;
    // Iterating from bottom-up
    for(int i = length-2; i>=0; i--) {
      for(int j = 0; j<length; j++) {
        // First column case
        if(j==0) {
          matrix[i][0] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
        }
        // Last column case
        else if(j == length-1) {
          matrix[i][length-1] += Math.min(matrix[i+1][length-2], matrix[i+1][length-1]);
        }
        // Middle column case
        else {
          matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
        }
      }
    }
    int min = Integer.MAX_VALUE;
    // Finding the minimum.
    for(int i = 0; i<length; i++) {
      if(matrix[0][i]<min) min = matrix[0][i];
    }
    return min;
  }
}