//Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++)
            dp[m - 1][i] = matrix[m - 1][i];

        for (int i = m - 2; i >= 0; i--)
            for (int j = 0; j < n; j++) {
                if (j > 0 && j < n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j - 1], dp[i + 1][j + 1]));
                    continue;
                } else if (j < n - 1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                else if (j > 0)
                    dp[i][j] += matrix[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j - 1]);
            }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            if (min > dp[0][j])
                min = dp[0][j];
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 100, -42, -46, -41 }, { 31, 97, 10, -10 }, { -58, -51, 82, 89 },
                { 51, 81, 69, -51 } };
        int x = minFallingPathSum(matrix);
        System.out.println(x);

    }
}
