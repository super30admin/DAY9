// Time : O(n)
// Space: O(n)

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {

        int max_num = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            max_num = max(max_num, nums[i]);
        }
        
        vector<int> count_nums(max_num+1,0); 
        vector<int> dp(max_num+1);

        for(int i = 0; i < nums.size(); i++)
        {
            count_nums[nums[i]] += nums[i];
            max_num = max(max_num, nums[i]);
        }

        dp[0] = count_nums[0];
        dp[1] = count_nums[1];

        for(int i = 2; i <= max_num; i++)
        {
            dp[i] = max(count_nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[max_num];

    }
};