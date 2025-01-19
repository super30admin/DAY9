// TC : O(m*n)
//  SC : O(1)
//  Did this code successfully run on Leetcode : yes
//  Any problem you faced while coding this : no
class Solution
{
public:
    int minFallingPathSum(vector<vector<int>> &matrix)
    {
        if (matrix.size() < 0 || matrix.empty())
        {
            return 0;
        }

        for (int i = matrix.size() - 2; i >= 0; i--)
        {
            for (int j = 0; j < matrix[0].size(); j++)
            {
                if (j == 0)
                {
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if (j == matrix[0].size() - 1)
                {
                    matrix[i][j] += min(matrix[i + 1][j - 1], matrix[i + 1][j]);
                }
                else
                {
                    matrix[i][j] += min(matrix[i + 1][j - 1], min(matrix[i + 1][j], matrix[i + 1][j + 1]));
                }
            }
        }

        int minEle = INT_MAX;
        for (int i = 0; i < matrix[0].size(); i++)
        {
            minEle = min(minEle, matrix[0][i]);
        }

        return minEle;
    }
};