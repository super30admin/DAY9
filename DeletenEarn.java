/** 
Approach: Think of storing occurences in an array with length as max value in array 
One decision making [arameter we use 1-D array as DP table

once we have array -> use take/notTake approach in that array to use :
Max(Current or previous)

TC- O(n)+O(max(n)), SC - O(max(n))(resultant array length = max value in given array)
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max =0;
        // max value in array
        for(int i = 0; i<n;i++){
            max = Math.max(max,nums[i]);
        }
        // create a simplifed array,
        int[] dp = new int[max+1];

        for(int i =0;i<n;i++){
            dp[nums[i]]+=nums[i];
        }

        // reduced to house robber
        int prev = dp[0];
        int curr = Math.max(dp[0], dp[1]);

        for(int i =2;i<dp.length;i++){
            int temp = curr;
            curr = Math.max(curr, prev+dp[i]);
            prev = temp;
        }
        return curr;
    }
}