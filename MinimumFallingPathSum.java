//MEMOIZATION
/* Time Complexity: O(m*n) - matrix dimensions.
 * Space Complexity: atmost we solve m*n subproblems so the space to store is O(m * n).
 * Leetcode: yes
 * Any Problems: no
 */

 //TABULATION
/* Time Complexity: O(m*n) - matrix dimensions.
 * Space Complexity: atmost we solve m*n subproblems so the space to store is O(m*n). can be optimized to O(n) as we are just using previous row.
 * Leetcode: yes
 * Any Problems: no
 */

import java.util.Arrays;

public class MinimumFallingPathSum {
        //MEMOIZATION
        private int getMinSum(int[][] matrix, int row, int col, int[][] memo)
        {
            if(memo[row][col] != Integer.MAX_VALUE)
                return memo[row][col];
            
            int[][] xy = new int[][]{{1, -1}, {1, 0}, {1, 1}};
            int currentMin = Integer.MAX_VALUE;
            for(int i=0; i<xy.length; i++)
            {
                int nrow = row + xy[i][0];
                int ncol = col + xy[i][1];
                if(nrow<matrix.length && ncol>=0 && ncol<matrix[0].length)
                {
                   currentMin = Math.min(currentMin, getMinSum(matrix, nrow, ncol, memo));
                }
            }
            memo[row][col] = matrix[row][col] + currentMin;
    
            return memo[row][col];
        }
    
        public int minFallingPathSumMemoization(int[][] matrix) {
            int minSum = Integer.MAX_VALUE;
            int[][] memo = new int[matrix.length][matrix[0].length];
            
            for(int i=0; i<matrix.length; i++)
            {
                if(i == matrix.length-1)
                    System.arraycopy(matrix[i], 0, memo[i], 0, matrix[i].length);
                else
                    Arrays.fill(memo[i], Integer.MAX_VALUE);
            }
    
            for(int i=0; i<matrix[0].length; i++)
                minSum = Math.min(minSum, getMinSum(matrix, 0, i, memo));
            return minSum;
        }
    

        //TABULATION
        public int minFallingPathSumTabulation(int[][] matrix)
        {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
    
            for(int i=0; i<n; i++)
                dp[m-1][i] = matrix[m-1][i];
            
            for(int i=m-2; i>=0; i--)
            {
                for(int j=0; j<n; j++)
                {
                    int currentMin = Integer.MAX_VALUE;
                    int[][] xy = new int[][]{{1, -1}, {1, 0}, {1, 1}};
                    for(int k=0; k<xy.length; k++)
                    {
                        int nrow = i + xy[k][0];
                        int ncol = j + xy[k][1];
                        if(nrow<m && ncol>=0 && ncol<n)
                            currentMin = Math.min(currentMin, dp[nrow][ ncol]);
                    }
                    dp[i][j] = matrix[i][j] + currentMin;
                }
            }
            int result = Integer.MAX_VALUE;
            for(int i=0; i<n; i++)
                result = Math.min(result, dp[0][i]);
            
            return result;
        }
    
}
