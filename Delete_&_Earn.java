// Time Complexity : O(n) + O(Max Element)
// Space Complexity : O(Max Element)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// create dp array of length of Max Element + 1.
// add each element as per respective index in dp array
// Use house robber algo on DP array of length max element 
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0; i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int dp[] = new int[max +1];

        for(int i=0; i<nums.length; i++){
            int idx = nums[i];
            dp[idx] += idx;
        }

        int skip = 0;
        int take = dp[0];
        for (int i=1; i<max+1; i++){
            int skipTemp = skip;
            skip = Math.max(skip, take);
            take = skipTemp + dp[i];
        } 
        return Math.max(skip,take);
    }
}