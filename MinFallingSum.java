// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/* Starting from bottom up we calculate the minimum sum for each element of the row. If its an end element the we have only 2 brances to check otherwise we have three.
 * the minimum of all the elements in 1st row will give the answer.
 */
public class MinFallingSum{
    public int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {       //O(n)
            dp[m - 1][i] = matrix[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {          //O(m*n)
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : dp[0]) {   //O(n)

            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}