/*
    LC - 740. Delete and Earn
    TC - O(n) + O(max element in array) ~ O(max(n, max element in array))
    SC - O(max element in array)
*/


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        for(int i=0; i<nums.length; i++) {
            int index = nums[i];
            dp[index] = dp[index] + index;
        }
        int skip = 0, take = dp[0];
        for(int i=1; i<max + 1; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);
    }
}