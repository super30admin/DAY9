// Time Complexity : O(m*n)
// Space Complexity : O(1) no additional space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach - used the same matrix and updated the
// value after the first row, took the min value from the above row based on the condition
//then updated the value from the matrix.


/**
 *  MinFallingPath : MinFallingPath
 *
 * @author : Kavya Mandaliya
 * @version : 1.0 (Nov 06, 2024)
 * @since : 1.0 (Nov 06, 2024)
 *
 */
 public class MinFallingPath {
   public int minFallingPathSum(int[][] matrix) {
      int minSum = Integer.MAX_VALUE;
      for(int r =1; r < matrix.length; r++){
        for(int c = 0; c< matrix[0].length; c++){
          int value = Math.min((c > 0 ? matrix[r-1][c-1] : Integer.MAX_VALUE),
                  Math.min(matrix[r-1][c],
                          (c < matrix[0].length-1 ? matrix[r-1][c+1] : Integer.MAX_VALUE)));
          matrix[r][c] = value + matrix[r][c];
        }
      }
      for(int c = 0; c < matrix[0].length; c++){
         minSum = Math.min(minSum, matrix[matrix.length-1][c]);
      }
      return minSum;
   }
}
