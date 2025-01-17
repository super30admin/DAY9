/* Description: If we do some preprocessing on the input array, like storing all the occurrences as a combined sum at one index in dp array, 
this problem then resembles house robber, where we had to pick one and avoid adjacent one. Using 2 variables to store the value of 
pick the element or do not pick the element. At any current row, the value of do not pick the element is given by max of previous 
row values, and the value of pick the element is given by adding the value of picking the current element to the do not pick value of 
previous element. Getting the final ans from the max of skip and take.
 */

// Time Complexity : O(Max(maxelement,n))
// Space Complexity : O(maxElement)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int deleteAndEarn(int[] nums) {
        // Base Condition
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Find out max element in input array
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // Declare a new array of size maxelement+1
        int[] dp = new int[max + 1];
        // Store sum of all the occurrences of one vale of input array at indices in dp
        // array
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            dp[index] = dp[index] + nums[i];
        }
        // Iterate through dp array and find out max points
        // skip for storing the points if we do not pick that value
        int skip = 0;
        // take for storing the points if we pick that value
        int take = 0;
        for (int i = 1; i < max + 1; i++) {
            int tempSkip = skip;
            // skip value will be max of previous two because, since we are skipping
            // current, it doesn't matter whether we pick previous or not
            skip = Math.max(skip, take);
            // take value will sum of previous row skip and the current value points
            take = tempSkip + dp[i];
        }
        // Return max of skip and take
        return Math.max(skip, take);
    }
}