// ## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

// Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
// Return the maximum number of points you can earn by applying the above operation some number of times.

 

// Example 1:

// Input: nums = [3,4,2]
// Output: 6
// Explanation: You can perform the following operations:
// - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
// - Delete 2 to earn 2 points. nums = [].
// You earn a total of 6 points.
// Example 2:

// Input: nums = [2,2,3,3,3,4]
// Output: 9
// Explanation: You can perform the following operations:
// - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
// - Delete a 3 again to earn 3 points. nums = [3].
// - Delete a 3 once more to earn 3 points. nums = [].
// You earn a total of 9 points.

//Approach: 
Step 1: As the array was not sorted so there may be a scenario if we pick a element and that element might appear again so to overcome this we found the largest element
Step 2: We will initialize the array whose length is max element + 1
step 3: Now we will iterate through our nums array and we will add each value to the new array
step 4: Ones the array is ready we will declare 2 variables 1. will be skip (We are skipping that element), 2. take(We are taking that element)
step 5: At the end we will return the max of both

// Time Complexity : O(Max(nums.length,maximum element))
// Space Complexity :O(maximum element) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int deleteAndEarn(int[] nums) {
        //Base Condition check
        if(nums==null || nums.length==0){
            return 0;
        }
        //Step to find the max elemnt
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        //Initialized an array of max+1 length
        int dp[]=new int[max+1];

        for(int i=0;i<nums.length;i++){
            dp[nums[i]]=dp[nums[i]]+nums[i];
        }
        //Instead of 2-D array we are just using 2 variables
        int skip = 0;
        int take=0;
        for(int i=1;i<dp.length;i++){
            int temp = skip;
            skip=Math.max(skip,take);
            take=temp+dp[i];
        }
    //Returning the maximum of skip and take
    return Math.max(skip,take);
    }
}