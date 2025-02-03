// Time Complexity : O(m + n) where n is the nums length and m is maximum element in nums
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Array arr to accumulate the total value for each number in the input, then applying dynamic
// programming to find the maximum sum that can be earned by deleting numbers,
// ensuring that no two adjacent numbers are selected.

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;

        // find max element
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            arr[curr] += curr;
        }

        int prev = arr[0];
        int curr = Math.max(prev, arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}