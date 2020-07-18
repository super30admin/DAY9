// Time Complexity : O(max(m, n)) --> where n is length of input array and m is the maximum element of the input array
// Space Complexity : O(m)
// Did this code successfully run on Leetcode (740): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]); 
        }
        
        int arr[] = new int[max+1];
        
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i]; 
        }
        
        int skip = 0;
        int take = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = arr[i] + temp;
        }
        
        return Math.max(skip, take);
    }
}