// Overall Time Complexity : O(m*n) . The m*n is number of elements in the given matrix .
// Overall Space Complexity : O(m*n) . The space complexity is the number of elements in the dp matrix; 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// This solution calculates the minimum falling path sum in a matrix.  
// A new DP matrix is created, and the last row values from the original matrix are stored in it.  
// For each element in the matrix, we check for the minimum path by considering the value directly below or diagonally left/right in the next row.  

public class PathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        
        for(int i = 0; i<n; i++){
            dp[n-1][i]= matrix[n-1][i];
        }

        for(int i = n-2; i>=0; i--){
            for (int j = 0; j<n;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j==n-1){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j-1]);
                }
                else{
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j-1], Math.min(dp[i+1][j],dp[i+1][j+1]));
                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = 0 ;i< n;i++){
            minSum = Math.min(minSum, dp[0][i]);

        }
        return minSum;
    }
}