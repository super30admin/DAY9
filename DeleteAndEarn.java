// Time Complexity : O(n)
// Space Complexity : O(n) + O(max element)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public int deleteAndEarn(int[] nums) {
    int max = Integer.MIN_VALUE;
    // Finding the max element
    for(int i = 0; i<nums.length; i++) {
      if(nums[i]>max) max = nums[i];
    }

    // Creating an array with the size = max +1 elements.
    int[] sumArray = new int[max+1];
    for(int num: nums) {
      sumArray[num] += num;
    }

    // Creating a dp array of size 2.
    int[] dp = new int[2];
    int skip = dp[0];
    int take = dp[1];
    for(int i = 1; i<sumArray.length; i++) {
      int skipTemp = skip;
      int takeTemp = take;
      // First element is maximum of the previous two elements.
      skip = Math.max(skipTemp, takeTemp);
      // Second element is the sum of the first previous and sumArray[i]
      take = skipTemp + sumArray[i];
    }
    return Math.max(skip, take);
  }
}