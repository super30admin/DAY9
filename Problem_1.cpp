// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 740: Delete and Earn
// Approach: Dynamic Programming
// Time Complexity: O( max(n, m)) --> m is max value in the array

class Solution
{
public:
    int deleteAndEarn(vector<int> &nums)
    {
        int maxNum = 0;

        // Find the max value in the nums array
        for (int i = 0; i < nums.size(); i++)
        {
            maxNum = std::max(maxNum, nums[i]);
        }

        // Create a dp array to store the sum of points for each number
        vector<int> dp(maxNum + 1, 0);

        // Populate the dp array with the sum of points for each number
        for (int i = 0; i < nums.size(); i++)
        {
            int index = nums[i];
            dp[index] = dp[index] + nums[i];
        }

        int skip = 0;
        int take = 0;

        // Iterate through the dp array to calculate the maximum points
        for (int i = 1; i < maxNum + 1; i++)
        {
            int tempSkip = skip;     // Store the previous skip value
            skip = max(skip, take);  // Update skip to the maximum of skip or take
            take = tempSkip + dp[i]; // Update take by adding current dp[i] to previous skip
        }

        // Return the maximum of skip or take as the result
        return max(skip, take);
    }
};
