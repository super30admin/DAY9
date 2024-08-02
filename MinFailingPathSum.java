// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class MinFailingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        System.arraycopy(matrix[n - 1], 0, dp[n - 1], 0, n);

        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                int minVal = dp[i+1][j];
                if (j > 0) {
                    minVal = Math.min(minVal, dp[i+1][j-1]);
                }
                if (j < n - 1) {
                    minVal = Math.min(minVal, dp[i+1][j+1]);
                }
                dp[i][j] = matrix[i][j] + minVal;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,2,1,6},{7,3,9,2},{1,10,13,8},{12,13,4,3}};
        System.out.println("Min Falling path sum from given matrix is " + minFallingPathSum(matrix));
    }
}