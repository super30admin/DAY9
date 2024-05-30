// Time Complexity : O(n) + O(max(n)), n is the length of the array
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        int max = 0;
        //get the maximum value of the input array
        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        //create an array of maximum value size
        int[] arr = new int[max+1];
        for(int i = 0; i < n; i++) {
            arr[nums[i]] += nums[i]; // keep count of each value in the array
        }
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i]+prev);
            prev = temp;
        }
        return curr;
    }
}