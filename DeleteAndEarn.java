// Problem 740. Delete and Earn
// Time Complexity : O(n + max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        // Find the maximum value in nums
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] values = new int[max + 1];
        // Sum up the values for each number
        for (int num : nums) {
            values[num] += num;
        }
        // Use dynamic programming to find the maximum points
        int prev = values[0];
        int curr = Math.max(values[0], values[1]);
        for (int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, values[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
