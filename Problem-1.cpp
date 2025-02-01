//https://leetcode.com/problems/delete-and-earn/description/

// Time Complexity : O(n+m) where n is the length of the input array and m is the max element
// Space Complexity : O(m) where m is the max element
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Find the max element in the input and define an array of max element+1.
// Create a vector of size max element+1, and initilazie with 0's. For each element in the input array, add the sum of points for each value in dp.
// For each value in the dp, find the maximum points by taking the max of previous element or the sum of the current and the element 2 indices away.


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        int maxNum = INT_MIN;
        for(int num : nums){
            maxNum = max(maxNum, num);
        }
        vector<int> dp(maxNum+1,0);
        for(int i:nums){
            dp[i] += i;
        }
        for(int i=2; i<=maxNum; i++){
            dp[i] = max(dp[i-1], dp[i]+dp[i-2]);
        }
        return dp[maxNum];
    }
};