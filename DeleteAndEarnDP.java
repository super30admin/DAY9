//## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Time: Max(O(N), max(N))
// Space: O(max(N))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// approach - similar to house robber, group elements by freq*value


class Solution {
    // DP solution
    // Time: Max(O(N), max(N))
    // Space: O(max(N))
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)  return nums[0];

        // group elements by freq*value
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max, num);
        }

        int[] processed = new int[max+1];
        for(int num:nums){
            processed[num] += num;
        }

        int[] dp = new int[max+1];
        int prev = processed[0];
        int curr = Math.max(prev, processed[1]);

        for(int i=2;i<=max;i++){
            int next = Math.max(curr, processed[i] + prev);
            prev = curr;
            curr = next;
        }

        return curr;
    }
}