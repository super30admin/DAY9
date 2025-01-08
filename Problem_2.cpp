// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 931: Minimum Falling Path Sum
// Approach: Dynamic Programming
// Time Complexity: O(n^2)

class Solution
{
public:
    int minFallingPathSum(vector<vector<int>> &matrix)
    {

        // Base Case
        if (matrix.empty() || matrix.size() == 0)
        {
            return 0;
        }

        int n = matrix.size();

        // Start from bottom of the matrix
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = 0; j < n; j++)
            {
                // Condition for element in most left
                if (j == 0)
                {
                    matrix[i][j] =
                        matrix[i][j] +
                        std::min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                // Condition for element in most right
                else if (j == n - 1)
                {
                    matrix[i][j] =
                        matrix[i][j] +
                        std::min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                // Condition for element in center
                else
                {
                    matrix[i][j] =
                        matrix[i][j] + std::min(std::min(matrix[i + 1][j],
                                                         matrix[i + 1][j - 1]),
                                                matrix[i + 1][j + 1]);
                }
            }
        }

        // Min path will be stored on top, so iterate over first row and return the min sum
        int min = INT_MAX;
        for (int i = 0; i < n; i++)
        {
            min = std::min(min, matrix[0][i]);
        }

        return min;
    }
};