// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach using a dynamic programming approach (dp):
 *  initialized with values from matrix A.
 *  Iterate through dp from bottom to top, updating each cell based on the minimum path sum from the row below.
 *  Compute the minimum sum from the top row of dp and return minsum.
 */

 class Solution {
    public int minFallingPathSum(int[][] A) {
       
        int[][] dp = new int[A.length][A[0].length];
        int minsum=Integer.MAX_VALUE;
        for(int j=0; j<A[0].length; j++)
        {
            dp[A.length-1][j]=A[A.length-1][j];
        }
        
        for(int i=dp.length-2; i>=0;i--)
        {
            for(int j=0; j<dp[0].length; j++)
            {
                if(j==0)
                {
                    dp[i][j]=A[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j==dp[0].length-1)
                {
                    dp[i][j]=A[i][j]+Math.min(dp[i+1][j],dp[i+1][j-1]);
                }
                else
                {
                   dp[i][j]= A[i][j]+Math.min(Math.min(dp[i+1][j],dp[i+1][j-1]),dp[i+1][j+1]);
                }
            }
        }
      
        for(int j=0; j<dp[0].length; j++)
        {
            
            minsum=Math.min(minsum,dp[0][j]);
       
        }
       return minsum;
    }
}