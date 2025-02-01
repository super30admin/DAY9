// Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

// Time Complexity : O(nxn)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, dynamic programming is used. Updating the element with minimum element among left, same column, right column of the row below. Finally,
 * the minimum element from the 0th row is returned which has the minimum sum of the path traversed till last row of matrix.
 */


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(matrix == null || matrix.length == 0) return 0;
        if(n==1) return matrix[0][0];
        // int [][]dp = new int[n][n];
        // for(int i = 0;i<n;i++){
        //     dp[n-1][i] = matrix[n-1][i];
        // }
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<n; j++){
                // int direct = dp[i+1][j];
                int direct = matrix[i+1][j];
                int left, right;
                if(j>0){
                    // left = dp[i+1][j-1];
                    left = matrix[i+1][j-1];
                }
                else{
                    left = Integer.MAX_VALUE;
                }
                if(j<n-1){
                    // right = dp[i+1][j+1];
                    right = matrix[i+1][j+1];
                }
                else{
                    right = Integer.MAX_VALUE;
                }
                // dp[i][j] = matrix[i][j]+ Math.min(direct, Math.min(left,right));
                matrix[i][j] = matrix[i][j]+ Math.min(direct, Math.min(left,right));
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            // res = Math.min(dp[0][i],res);
            res = Math.min(matrix[0][i],res);
        }
        return res;
    }
}
