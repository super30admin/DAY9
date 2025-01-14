// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

/*Recursion was TLE having time complexity : O(n^n)
Modifying original matrix by taking minimum sum at every point(bottom-up) 
and returning min front from first row(all sums are stored there)*/ 
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j==0){ // for first column cannot do j-1
                    matrix[i][j]+= min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j ==n-1){  // for last column cannot do j+1
                    matrix[i][j]+= min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{ // for any element j>0 and j<n-1
                    matrix[i][j]+= min(matrix[i+1][j],min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }
    int ans = INT_MAX;
    for(int j =0; j<n; j++){
        ans = min(ans, matrix[0][j]);
    }
    return ans;
    }
};