// Time Complexity : O( max (n, element))
// Space Complexity : O(max element)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){ // finding out the largest number
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max+1]; // creating an array with length max, our largest number
        for(int i = 0; i < nums.length ;i ++){ // creating the array for house robber 
            int index = nums[i];
            dp[index] = dp[index] + index;
        }
        int skip = 0;
        int take = dp[0];
        for(int i = 0; i < max + 1; i++){ // house robber
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = dp[i] + tempSkip;
        }

        return Math.max(take, skip);
    }
}