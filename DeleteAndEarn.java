//TC: O(max (max value of Nums array,nums length))
//OC: O(max value of nums  array)
//Approach: Convert the nums array into house robber array by calculating the value provided by each nums[i] at index [num[i]]. Now similarly dont rob the adjacent houses and calculate maximum using dp solution.

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) return nums[0];

        int maxV = 0;
        for(int num : nums) maxV = Math.max(maxV, num); //O(n)
        
        int[] dp = new int[maxV+1]; //creating house robber array
         for(int num : nums){
            dp[num] += num;
        }

        int prev=dp[0];
        int curr = Math.max(dp[0],dp[1]);
        for (int i=2;i<=maxV;i++){ //O(max(n))
            int tmp = curr;
            curr = Math.max(curr, dp[i] + prev); 
            prev = tmp;
        }

        return curr;
    }
}