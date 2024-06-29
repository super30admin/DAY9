// Time Complexity :O(m+n)
// Space Complexity :o(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public int deleteAndEarn(int[] nums) {
        // Find the maximum value in the nums array to determine the size of the arr array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Initialize an array to store the total value accumulated for each number
        int[] arr = new int[maxVal + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        // Initialize the dp array to store the maximum points up to each index
        int[] dp = new int[arr.length];
        dp[0] = 0; // Base case: no points for index 0
        dp[1] = Math.max(dp[0], arr[1]); // Base case: max points for index 1

        // Iterate over the remaining indices
        for (int idx = 2; idx < arr.length; idx++) {
            // Choose the maximum between not picking the current index (dp[idx-1]) and
            // picking the current index plus the maximum from two indices before (arr[idx] + dp[idx-2])
            dp[idx] = Math.max(dp[idx - 1], arr[idx] + dp[idx - 2]);
        }

        // The last element in dp array contains the maximum points that can be earned
        return dp[arr.length - 1];
    }
}
