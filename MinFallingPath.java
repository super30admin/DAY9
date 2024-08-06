// Time complexity = O(n^2)
// Space Complexity = O(n^2)
// Similar to house paint problem. Only difference is that the 
// matrix is not constant unlike no. of paints.

// Approach followed -
// say we want to find out the value at (i,j), then there can be 3 ways to reach i,j
// from (i-1,j-1); (i-1,j); (i-1,j+1)
// depending on conditions we find the minimum at each level.
// for eg - for the 0th row, the value will be what is always was matrix[0][i] // the initial value
// for all others, we don't want to go out of bounds so we load up on conditions.
// at the last row, we get the answer.
class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i< n ;i++) {
            dp[0][i] = matrix[0][i];
        }
        for(int i=0;i< n; i++) {
            for(int j=0;j< n;j++) {
                if(i==0) {
                    continue;
                }
                // just reverse it.
                // if(row+1, col-1)=>[row-1, col+1], 
                // if (row + 1, col + 1) => [row-1, col-1]
                //if (row+1, col)=>[row-1, col]
                if(j==0) {// 1,0-> (0, 1), (0, -1). so no, (0,0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j+1], dp[i-1][j]);
                } else if(j== n-1) {// 1,2 => 0,3(so no), (0,1), (0,2)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j+1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                }
            }
        }
        int min= 9999999;// max value. 
        // The last row will have the values for each sequence.
        for(int i=0;i<n;i++){
            min = Math.min(dp[n-1][i],min);
        }
        return min;
    }
}

// recursion
// Time complexity = O(n*2^n)
// Space Comlexity = n
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         return Math.min(recursion(matrix, 0,0), Math.min(recursion(matrix, 0,1), recursion(matrix, 0,2)));
//             // matrix,i,j<- matrix, row, col
//     }
    
//     private int recursion(int[][] matrix, int i, int j) {
//         // base case
//         if(i>= matrix.length || j>= matrix.length) {
//             return 999;
//         }
//         if(i<0 || j<0) {
//             return 999;
//         }
//         if(i== matrix.length-1) {
//             return matrix[i][j];
//         }
//         // logic
//         int case1 = recursion(matrix, i+1,j);
//         int case2= recursion(matrix,i+1,j-1);
//         int case3= recursion(matrix,i+1,j+1);
//         return matrix[i][j] + Math.min(case1, Math.min(case2, case3));
//     }
// }