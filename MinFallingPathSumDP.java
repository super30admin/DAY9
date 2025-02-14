// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Time: O(N*N)
// Space: O(N*2) 
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Start from the bottom, and store the value of each sub-problem


class Solution {
    // DP 
    // Time: O(N*N)
    // Space: O(N*2) 
    private int dpSol(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[2][n];

        // Fill in last row
        for(int i=0;i<n;i++){
            dp[1][i] = matrix[n-1][i];
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                //down
                dp[0][j] = dp[1][j];
                //left
                if(j>=1)    dp[0][j] = Math.min(dp[0][j], dp[1][j-1]);
                //right
                if(j+1<n)   dp[0][j] = Math.min(dp[0][j], dp[1][j+1]);

                //add the value of curr node
                dp[0][j] += matrix[i][j];
            }

            dp[1]=dp[0];
            dp[0]=new int[n];
        }

        //Get min from first row
        int mini = dp[1][0];
        for(int i=1;i<n;i++){
            mini = Math.min(dp[1][i], mini);
        }
        return mini;
    }

    public int minFallingPathSum(int[][] matrix) {
        return dpSol(matrix);
    }
}