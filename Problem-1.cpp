// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution
{
public:
    int deleteAndEarn(vector<int> &nums)
    {
        if (nums.empty())
        {
            return -1;
        }
        int maxEle = 1;

        // search for the max element to create the dp vector
        for (int i = 0; i < nums.size(); i++)
        {
            maxEle = max(maxEle, nums[i]);
        }

        vector<int> dp(maxEle + 1, 0);

        // sum up the elements for respective index
        for (int i = 0; i < nums.size(); i++)
        {
            dp[nums[i]] += nums[i];
        }

        int skip = 0, take = 0;

        // keep track of element to skip or take
        for (int i = 0; i < dp.size(); i++)
        {
            int temp = skip;
            skip = max(skip, take);
            take = dp[i] + temp;
        }

        return max(skip, take);
    }
};