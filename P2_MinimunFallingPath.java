// Time Complexity : O(nm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int min = 999999;
        for(int row=rows-2; row>=0 ; row--) {
            for(int col=0 ; col<cols ;col++) {
                int currMin= 999999;
                if(col-1 >= 0 && matrix[row+1][col-1] < currMin) {
                    currMin = matrix[row+1][col-1];
                }
                if(col+1 <cols && matrix[row+1][col+1] < currMin) {
                    currMin = matrix[row+1][col+1];
                }
                if(matrix[row+1][col] < currMin) {
                    currMin = matrix[row+1][col];
                }
                matrix[row][col] += currMin;
            }
        }

        for(int i=0 ;i<cols ;i++) {
            if(matrix[0][i] < min) {
                min=matrix[0][i];
            }
        }
        return min;
    }
}