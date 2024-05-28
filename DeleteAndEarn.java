// Time Complexity : O(n)+O(max element)
// Space Complexity :O(max element)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

// logic: Create an array dp where dp[i] stores the total points obtainable by deleting all instances of i from nums.
// Use two variables, skip and take, to keep track of the maximum points when skipping or taking the current number. Update them iteratively to ensure no consecutive numbers are taken.
// After processing all possible values, the result is the maximum value between skip and take.

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for(int i =0 ; i< nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max+1];

        for(int i=0; i<nums.length; i++){
            int index = nums[i];
            dp[index] = dp[index]+index;
        }

        int skip = 0;
        int take = dp[0];

        for(int i=1; i<=max; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}