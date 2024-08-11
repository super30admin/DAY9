// Time : O(n2)
// Space: O(n2)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        vector<vector<int>> dp(matrix.size(), vector<int>(matrix[0].size()));

        // fill in last row of matrix as is
        for(int col = 0; col < matrix[0].size(); col++)
        {
            dp[matrix.size() - 1][col] = matrix[matrix.size() -1][col];
        }

        for(int row = matrix.size() -2; row >= 0; row--)
        {
            for(int col = 0; col < matrix[0].size(); col++)
            {
                if(col == 0)
                {
                    dp[row][col] = matrix[row][col] + min(dp[row+1][col+1], dp[row+1][col]);
                }
                else if(col == matrix[0].size() - 1 )
                {
                    dp[row][col] = matrix[row][col] + min(dp[row+1][col-1], dp[row+1][col]);
                }   
                else
                {
                    dp[row][col] = matrix[row][col] + min(dp[row+1][col+1], min(dp[row+1][col-1], dp[row+1][col]));

                }

            }
        }

        // iterate over first row and figure out the min
        int falling_sum = dp[0][0];
        for(int col = 1; col < matrix[0].size(); col++)
        {
            falling_sum = min(falling_sum, dp[0][col]);
        }

        return falling_sum;
    }
};