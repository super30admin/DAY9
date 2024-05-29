//Time Complexity - O(n)
//Space Complexity - O(max) - Time taken to find the max element. 
//Leetcode - Yes
//Approach - In this problem, if we consider deleting one element -> we can earn points associated with that element. We dont get points for the element index + 1 and element index -1
//We initially try to find the max element in the array. Create an array of the size of max, and store the earning of each number. Using this, I use the two variables skip and take to find the maximum earning to be made. 
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0|| nums == null){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        for(int i = 0; i < nums.length; i++){
            int index = nums[i];
            dp[index] = dp[index] + index;
        }
        int skip = 0; 
        int take = dp[0];
        for(int i = 1; i < max + 1; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = dp[i] + tempSkip;
        }
        return Math.max(skip,take);
    }
}