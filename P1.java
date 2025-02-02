// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            arr[curr] += curr;
        }
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
