// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : NO
// Any problem you faced while coding this : Struggled a bit with tabular solution

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    // int helper(vector<vector<int>>& matrix, int i, int j) {
    //     if (i == matrix.size()) return 0;
    //     if (j<0 || j == matrix[0].size()) return 99999;

    //     // choose left
    //     int l = helper(matrix, i+1, j-1);

    //     // choose right
    //     int r = helper(matrix, i+1, j+1);

    //     //choose below
    //     int b = helper(matrix,i+1, j);

    //     return min(l, min(r,b)) + matrix[i][j];
    // }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        // int ans = INT_MAX;
        // for (int i=0; i<matrix[0].size(); i++) {
        //     ans = min (ans, helper(matrix, 0, i));
        // }
        // return ans;
        int r = matrix.size();
        int c = matrix[0].size();
        vector<int>prev(r+1, 0);
        vector<int>curr(r+1,0);
        for (int i = 0; i<r; i++) { 
            for (int j = 0; j<c; j++) {
                if (j == 0) curr[i] = min(prev[j+1], prev[j] + matrix[i][j]);
                if (j == c-1) {
                    curr[i] = min(prev[j-1], prev[j]) + matrix[i][j];
                }
                else {
                    curr[i] = min(prev[j-1], min (prev[j], prev[j+1])) + matrix[i][j];
                }
            curr = prev;
            }  
            prev = curr;     
        }
        int ans = INT_MAX;
        for (auto n:curr) {
            ans = min(ans, n);
        }
        return ans;
        }
};