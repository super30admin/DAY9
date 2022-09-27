// Time Complexity :O(n) + O(m)
// Space Complexity :O(m)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        int[] dp = new int[max + 1];
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i];
            dp[idx] = dp[idx] + nums[i];
        }
        
        int skip = 0;
        int take = dp[0];
        for(int i = 1; i < dp.length; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = dp[i] + temp;
        }
        
        return Math.max(skip,take);
    }
}
