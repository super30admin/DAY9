// Time Complexity : O(n*n) => As we are creating a 2D matrix and travesing through all the rows(n) and all the columns(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Started from the 2nd last row and adding the value of that cell with the min value from the next row. Lasrly, 1st row will have all the minimum values used for loop to calculate value of final min.
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {

        for(int i=matrix.length-2; i>=0 ; i--){
            for(int j =0; j<matrix.length; j++){

                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j == matrix.length -1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j+1], matrix[i+1][j]));
                }
            }
        }

        int minPath = Integer.MAX_VALUE;

        for(int i =0; i<matrix.length;i++){
            minPath = Math.min(minPath, matrix[0][i]);
        }
        return minPath;
    }

}

// This soultion uses recursive approch which is giving TLE
// class Solution {
//     int min = Integer.MAX_VALUE;

//     public int minFallingPathSum(int[][] matrix) {

//         for(int i =0; i<matrix.length; i++){
//             int sum = calculateSum(matrix, 0, i, matrix[0][i]);
//             min = Math.min(min, sum);
//         }
//         return min;
//     }

//     private int calculateSum(int[][] matrix, int row, int column, int sum){

//         int n = matrix.length -1;
//         if(row == matrix.length-1){
//             return sum;
//         }

//         if(column == 0){
//             sum = sum + Math.min(calculateSum(matrix, row+1, 0, matrix[row+1][0]), calculateSum(matrix, row+1, 1,matrix[row+1][1]));
//         }
//         else if(column == n){
//             sum = sum + Math.min(calculateSum(matrix, row+1, n, matrix[row+1][n]), calculateSum(matrix, row+1, n-1 ,matrix[row+1][n-1]));
//         }
//         else{
//             sum = sum + Math.min(calculateSum(matrix, row+1, column, matrix[row+1][column]), Math.min(calculateSum(matrix, row+1, column-1, matrix[row+1][column-1]), calculateSum(matrix, row+1, column+1, matrix[row+1][column+1])));
//         }

//     return sum;
//     }
// }