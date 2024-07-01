// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding a way to calculate minimum value from a row of
// values took some tries.

// Your code here along with comments explaining your approach
/*
The problem is similar to the paint house. Difference is the columns are not fixed-size and the min-sum should be
calculated as the min between col(directly below), col-1(left diagonal) and col+1(right diagonal) from the below row.
 */
public class MinFailingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        //Assigning the bottom row of dp as the same values of matrix
        System.arraycopy(matrix[n - 1], 0, dp[n - 1], 0, n);

        for(int i=n-2; i>=0; i--) { //O(n*n) T.C
            for(int j=0; j<n; j++) {
                int minVal = dp[i+1][j]; // Start with the same column below
                if (j > 0) {
                    minVal = Math.min(minVal, dp[i+1][j-1]); // Check left diagonal
                }
                if (j < n - 1) {
                    minVal = Math.min(minVal, dp[i+1][j+1]); // Check right diagonal
                }
                dp[i][j] = matrix[i][j] + minVal; //O(n*n) S.C
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
