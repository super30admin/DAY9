// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * approach:
 * Initialize and find the maximum value in nums to determine the size of dp. 
 * Populate dp where each index accumulates points from numbers in nums.
 *  Adjust dp values to maximize points considering adjacent numbers.
 *  Iterate backwards through dp to compute the maximum points achievable and return the result.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        int max =0;
    
        for(int n:nums)
        {
            max = Math.max(max, n);
        }
        
        if(max==1)
        {
            return nums.length;
        } 
        
        int[] dp = new int [max+1];
        Arrays.fill(dp,0);
        
        for(int i=0; i<nums.length; i++)
        {
            dp[nums[i]]+=nums[i];
        }
        
        dp[dp.length-2]=Math.max(dp[dp.length-2],dp[dp.length-1]);
        
        for(int i=dp.length-3; i>=0; i--)
        {
            
          if(dp[i]+dp[i+2]>=dp[i+1])
          {
              dp[i]=dp[i]+dp[i+2];
          }
          else
          {
             dp[i]=dp[i+1];
          }
            
        }
        
        return dp[0];
    }
}