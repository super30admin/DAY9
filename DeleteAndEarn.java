// Time Complexity : O(n) + O(max(max element in nums, frequenciesOfElements.length)) => O(max(max element in nums, frequenciesOfElements.length)) where frequenciesOfElements is the new matrix of size max +1
// Space Complexity : O(max element in nums)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes

/*
Approach: Tried with Recursion but it was giving TLE. After identifying that there are same sub-problems in the 0-1 recursion, used dynamic programming.
Created a new array of size max +1 where max represents the max value in nums array. This new array will store the earning of its corresponding index. This new row array will represent the rows in dp[]
and column will be 0(not selecting) and 1(selecting). For 0th column, it will hold the max of the above row and for 1st column add the corresponding row value to the not selected value in above row. Lastly return max of the last two values in dp matrix
 */
class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums.length == 0 || nums == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        //Calculates the max value present in the nums array
        for(int i =0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] frequenciesOfElements = new int[max+1];

        for(int i=0; i<nums.length; i++){
            int index = nums[i];
            frequenciesOfElements[index] = frequenciesOfElements[index] + index;
        }

        int[][] dp = new int[frequenciesOfElements.length][2];
        dp[0][0] = 0;
        dp[0][1] = frequenciesOfElements[0];

        for(int i =1; i<frequenciesOfElements.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + frequenciesOfElements[i];
        }

        return Math.max(dp[frequenciesOfElements.length-1][0], dp[frequenciesOfElements.length-1][1]);
    }
}

//This is recursive solution and it's time complexity will be 2^(max(max element in nums, frequenciesOfElements.length )) frequenciesOfElements is the new matrix of size max +1
// class Solution {
//     public int deleteAndEarn(int[] nums) {

//         if(nums.length == 0 || nums == null){
//             return 0;
//         }

//         int max = Integer.MIN_VALUE;

//         for(int i =0; i<nums.length; i++){
//             max = Math.max(max, nums[i]);
//         }
//         int[] frequenciesOfElements = new int[max+1];

//         //Creating a new array of size max + 1 which will store the earnings and its corresponding index represents the value
//         for(int i =0; i<nums.length; i++){
//             int index = nums[i];
//             frequenciesOfElements[index] = frequenciesOfElements[index] + index;
//         }

//         return maximumEarning(nums, frequenciesOfElements, 0, 0);

//     }

//     private int maximumEarning(int[] nums, int[] frequenciesOfElements, int index, int earning){

//         if(index >= frequenciesOfElements.length ){
//             return earning;
//         }

//         int case0 = maximumEarning(nums, frequenciesOfElements, index+1, earning);
//         int case1 = maximumEarning(nums, frequenciesOfElements, index+2, earning + frequenciesOfElements[index]);

//         return Math.max(case0, case1);
//     }
// }