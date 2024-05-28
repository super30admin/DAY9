// Time Complexity : O(max(n, max(nums))) where n is the size of nums and max(nums) is 
//                   maximum value in nums array.
// Space Complexity : O(max+max) = O(max), first max for storing coins array, second for
//                    dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int max = INT_MIN;
        for(int i=0;i<nums.size();i++)
            max = std::max(max, nums[i]);

        int coins[max+1];

        for (int i=0;i<max+1;i++)
            coins[i] = 0;

        for (int i=0;i<nums.size();i++)
            coins[nums[i]] = coins[nums[i]] + nums[i];

        int dp[max+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        int skip = 0;
        int take = coins[0];
        
        for(int i=1;i<max+1;i++)
        {
            dp[i][0] = std::max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + coins[i];
        }
        return std::max(dp[max][0], dp[max][1]);
    }
};