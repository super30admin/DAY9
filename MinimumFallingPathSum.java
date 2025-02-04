// Time Complexity : O(m * n) where m are the number of rows and n is the no. of cols
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinimumFallingPathSum {

    public static void main(String[] args)
    {
//        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix = {{-19, 57},{-40, -5}};
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        int i = dp.length - 1;
        for(int j = 0; j < dp[0].length; j++)
        {
            res = Math.min(res, dp[i][j]);
        }

        return res;
    }
}
