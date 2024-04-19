// Time Complexity : O(n)+O(maxValue)
// Space Complexity : O(maxValue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * To earn rewards we have to pick values such that the sorrounding n-1 and n+1 values are to be deleted
 * We can find the maxValue; then for each bucket of n count total rewards such that 
 * 
 * We can use running sum- to solve the problem
 * 
 * prev = dp[0]
 * curr = math.max(dp[0], dp[1])
 * 
 * -->
 * 
 */
public class DeleteAndEarnApproach2 {

    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int maxValue =0;
        for(int i=0; i<nums.length;i++){
            maxValue = Math.max(maxValue, nums[i]);
        }

        int[] dp = new int[maxValue+1];
        for(int i=0; i< nums.length; i++){
            dp[nums[i]]+=nums[i];
        }

        int prev=dp[0];
        int curr= Math.max(dp[0], dp[1]);

        for(int i=2; i<=maxValue;i++){
            int temp= curr;
            curr = Math.max(curr, prev+dp[i]);
            prev = temp;
        }

        return dp[maxValue];
    }

}