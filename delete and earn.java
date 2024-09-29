class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null ||nums.length==0) return 0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
        }
        
        int []dp = new int[maxi+1];

        for(int i=0;i<nums.length;i++){
            dp[nums[i]]+=nums[i];
        }
        dp[1]=Math.max(dp[0],dp[1]);
        for(int i=2;i<maxi+1;i++){
            dp[i]= Math.max(dp[i-1],dp[i-2]+dp[i]);
        }
        return dp[maxi];
    }
}
