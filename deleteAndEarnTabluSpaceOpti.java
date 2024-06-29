// Time Complexity :O(m+n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;

        // Find the maximum value in the nums array to determine the size of the arr array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Initialize an array to store the total value accumulated for each number
        int[] arr = new int[maxVal + 1];
        for (int num : nums) {
            arr[num] += num;
        }

        // Variables to store the maximum points up to the previous and current indices
        int prev = 0;
        int current = Math.max(0, arr[1]);

        // Iterate over the remaining indices starting from index 2
        for (int idx = 2; idx < arr.length; idx++) {
            int temp = current;
            // Calculate the maximum points for the current index by choosing the maximum
            // between not picking the current index and picking the current index plus
            // the maximum from two indices before
            current = Math.max(current, arr[idx] + prev);
            prev = temp;
        }

        // The current variable contains the maximum points that can be earned
        return current;
    }
}
