// Time Complexity :O(m+n)
// Space Complexity :o(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private int helper(int idx, int[] arr, int[] memoDp) {
        // Base case: if index is out of bounds, return 0
        if (idx >= arr.length) return 0;

        // Check if the result is already computed and stored in memoDp
        if (memoDp[idx] != -1) return memoDp[idx];

        // Recursively calculate the maximum points by either skipping or picking the current index
        return memoDp[idx] = Math.max(helper(idx + 1, arr, memoDp), arr[idx] + helper(idx + 2, arr, memoDp));
    }

    public int deleteAndEarn(int[] nums) {
        // Find the maximum value in the nums array to determine the size of arr and memoDp arrays
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Initialize memoization array with -1
        int[] memoDp = new int[maxVal + 1];
        Arrays.fill(memoDp, -1);

        // Initialize an array to store the total value accumulated for each number
        int[] arr = new int[maxVal + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        // Call the helper function starting from index 0
        return helper(0, arr, memoDp);
    }
}
