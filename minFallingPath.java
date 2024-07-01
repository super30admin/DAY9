/*
TC --> O(n*m)
SC --> O(n*m)

This question is similar to paint house problem where we need to consider the min of the next three elements
 */
class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        //Mark the last row as 
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }//for

        //bottom to top appraoch
        // case 1 at index i go to left diagonal, up, right diagonal if they are valid
        int[][] directions = new int[][]{{1, 1}, {1, 0}, {1, -1}};
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int min_val = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    int row = i + directions[k][0];
                    int col = j + directions[k][1];

                    //check if valid
                    if (row < 0 || row >= n || col < 0 || col >= m) {
                        continue;
                    }//if

                    min_val = Math.min(min_val, matrix[i][j] + dp[row][col]);

                }//for

                dp[i][j] = min_val;

            }//for

        }//for
        int res = Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //            System.out.print(dp[i][j]+" "); 
        //     }//for

        // }//for
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[0][i]);
        }

        return res;

    }
}
