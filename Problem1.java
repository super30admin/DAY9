/*
 Time Complexity : O(N) + O(highest)
 Space Complexity : O(highest)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No it was intuitive after solving House Robber problem.
*/

class Problem1 {
    public int deleteAndEarn(int[] nums) {
        // null check
        if(nums == null || nums.length == 0) return 0;
        // find maximum element
        int highest  = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){   //O(N)
            highest = (nums[i] > highest)? nums[i]: highest;
        }
        // Create dp array with element as index, and it's total sum/profit as value.
        int[] dp = new int[highest + 1];
        for(int i = 0; i < nums.length; i++){    //O(N)
            dp[nums[i]] += nums[i];
        }
        dp[0] = 0;
        /* Note: Once the array is created the problem falls into
        the house robber pattern of choose and not choose. */
        for(int i = 1; i < dp.length; i++){     //O(highest)
            if(i == 1){
                continue;
            }
            dp[i] = Math.max(dp[i-1], dp[i] + dp[i-2]);
            //            not choose  |   choose
            //            [1 step back] |  [2 steps back + current element]
        }
        return dp[highest];
    }
}