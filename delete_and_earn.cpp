// Time Complexity :O(n*max element of array)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        int max_element =0;  // as given elements are only positive
        for(int i =0; i<n ; i++){
            max_element = max(max_element, nums[i]);
        }

        vector<int> dp;
        dp.resize(max_element+1);  // for considering zero case
        for(int i=0; i<n; i++){
            dp[nums[i]]+= nums[i]; 
        }
        //avoiding to make 2D array as except previous none of the intermediate results required
        int skip =0; 
        int take =0;

        for(int i=1; i<max_element+1; i++){
            int tempSkip = skip;   //saving it in temp as it is getting updated.
            skip = max(skip, take);
            take = dp[i]+ tempSkip;   //taking current number+ if previous not chosen
        }
        return max(take, skip);
    }
};