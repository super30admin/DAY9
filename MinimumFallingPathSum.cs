// time complexity - O(n^2) where n= length of matrix
// space complexity - O(n) as we have used an 1-D array of length n
public class Solution
{
    public int MinFallingPathSum(int[][] matrix)
    {
        int n = matrix.Length;
        int[] dp = new int[n];

        for (int j = 0; j < n; j++)
        {
            dp[j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--)
        {
            int[] tmpDP = new int[n];
            for (int j = 0; j < n; j++)
            {
                // move straight down
                int down = dp[j];
                // move downLeft
                int downLeft = j > 0 ? dp[j - 1] : int.MaxValue;
                // move downright
                int downRight = j < n - 1 ? dp[j + 1] : int.MaxValue;
                // take min
                tmpDP[j] = matrix[i][j] + Math.Min(down, Math.Min(downLeft, downRight));
            }
            dp = tmpDP;
        }
        int minPathSum = int.MaxValue;
        for (int j = 0; j < n; j++)
        {
            minPathSum = Math.Min(minPathSum, dp[j]);
        }
        return minPathSum;
    }
}