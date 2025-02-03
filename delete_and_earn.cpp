// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will create a vector of size max element in the input array and store the sum of all elements with the same index in the vector.
//2. After reshaping data and making frequency array, it is just house robber

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.empty()){return 0;}

        int maxVal = 0;
        for(int i = 0; i < nums.size(); i++){
            maxVal = max(maxVal, nums[i]);
        }
        vector<int> freq(maxVal + 1, 0);
        for(int num : nums){
            freq[num] += num;
        }

        //House Robber
        vector<int> dp(maxVal + 1, 0);
        dp[0] = 0; 
        dp[1] = freq[1];
        for(int i = 2; i <= maxVal; i++){
            dp[i] = max(dp[i - 1], dp[i - 2] + freq[i]);
        }
        return dp[maxVal];
    }
};
