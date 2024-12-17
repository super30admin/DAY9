/*
    Leetcode problem 740: Delete and Earn 
    T.C: O(n) - O(2n) + O(m) :: S.C: O(m) - m: max val in nums

    Solved using DP approach: follows House Robber pattern where you 
    create a DP array of size equal to the max value in the nums array.
    Iterate over nums and add the element to it's equivalent index in
    DP array (i.e. if val = 2, add 2 at index 2 of DP array). Finally, 
    skip and take max values from the DP array (i.e. consider curr skip
    to be max of prev skip or take and take to be skip + curr val).
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max + 1];

        for (int i = 0; i < n; i++) {
            dp[nums[i]] += nums[i];
        }

        int skip = 0;
        int take = dp[0];

        for (int i = 1; i < max + 1; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}