// Time Complexity : O(m*n) m*n is the size of the matrix
// Space Complexity : O(1) if we can modify existing array else O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(j==0)
                    matrix[i][j] = matrix[i][j]+std::min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j==cols-1)
                    matrix[i][j] = matrix[i][j]+std::min(matrix[i-1][j], matrix[i-1][j-1]);
                else
                    matrix[i][j] = matrix[i][j]+std::min(matrix[i-1][j], std::min(matrix[i-1][j-1], matrix[i-1][j+1]));
            }
        }
        int min = INT_MAX;
        for(int i=0;i<cols;i++)
            min = std::min(min, matrix[rows-1][i]);

        return min;
    }

};