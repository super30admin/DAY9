// Create a DP array of length max, and fill the DP array
// TC: O(n+k) k: max value in nums
// SC: O(k)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            max = Math.max(max,nums[i]);
        }

        int dp[] = new int[max+1];
        for(int i=0;i<n;i++) {
            dp[nums[i]]++;
        }

        for(int i=2;i<=max;i++) {
            dp[i] = Math.max(dp[i-1],i*dp[i] + dp[i-2]);
        }
        return dp[max];
    }
}