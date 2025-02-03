// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// Did this code successfully run on Leetcode : Yes

//Approach: (Paint house but with instead of 3, we have n)
//1. We will create a dp matrix of same size as input matrix and fill the last row with the values of the last row of input matrix.
//2. Then we will iterate from second last row to the first row and for each element, we will calculate the minimum path sum from the next row and add the current element to it.
//3. Finally, we will return the minimum value from the first row of dp matrix.



class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<vector<int>> dp(n, vector<int> (n));
        for(int i = 0; i < n; i++){
            dp[n -1][i] = matrix[n - 1][i]; 
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int down = dp[i + 1][j];
                int downLeft = 0; 
                if(j > 0){
                    downLeft = dp[i + 1][j - 1];
                }else{downLeft = INT_MAX;}
                int downRight = 0; 
                if(j < n - 1){
                    downRight = dp[i + 1][j + 1];
                }else{downRight = INT_MAX;}
                dp[i][j] = matrix[i][j] + min(down, min(downLeft, downRight));
            }
        }
        int answer = INT_MAX; 
        for(int i = 0; i < n; i++){
            answer = min(answer, dp[0][i]); 
        }
        return answer;
    }
};



