/*
    1. Time Complexity : O(m + n) - m - max value in nums, n - amount
    2. Space Complexity : Memoization - O(m), Tabulation - O(m) 
    3. Did this code successfully run on Leetcode : Yes
    4. Any problem you faced while coding this : -
 */
import java.util.Arrays;
class Solution {
    static int[] dp;
    public static int helper(int[] arr, int i) {
        if (dp[i] != -1) return dp[i];
        dp[i] = Math.max(helper(arr, i -1), arr[i] + helper(arr, i-2));
        return dp[i];
    }
    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        int[] arr = new int[max + 1];
        for (int n : nums) {
            arr[n] += n;
        }
        dp = new int[max + 1];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);
        helper(arr, max);
        return dp[max];
    }

    public static int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int n : nums)
            max= Math.max(max, n);
        int[] score = new int[max+1];
        for (int n: nums) {
            score[n] +=n;
        }
        int prev = 0, curr = score[0], temp;
        for (int i = 1;i <= max; ++i) {
            temp = curr;
            curr = Math.max(curr, score[i] + prev);
            prev = temp;
        }
        return Math.max(curr, prev);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4,6,6,7,3,1,1};
        System.out.println("Using Memoization -- Delete and Earn:"+ deleteAndEarn(nums));
        System.out.println("Using Tabulation  -- Delete and Earn:"+ deleteAndEarn2(nums));
    }
}