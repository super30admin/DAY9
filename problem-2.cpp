// https://leetcode.com/problems/minimum-falling-path-sum/description/
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a vector dp and store the first row of the input.
// For each element from second row, calculate min value at each index by taking the min of up, left, and right, and add it to the value of that index in the matrix.
// Return the minimum value of the vector.

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<int> dp(matrix[0]);
        for(int i=1; i<n; i++){
            vector<int> curr(n,0);
            for(int j=0; j<n; j++){
                int left = (j > 0) ? dp[j-1] : INT_MAX;
                int right = (j < n-1) ? dp[j+1] : INT_MAX;
                int up = dp[j];
                curr[j] = matrix[i][j] + min(up, min(right,left));
            }
            dp = curr;
        }
        return *min_element(dp.begin(), dp.end());
    }
};