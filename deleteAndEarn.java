//TC:O(max)
//SC:O(max)
class deleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
// Finding the max element
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
// Creating a new array to hold the sum
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            dp[index] = dp[index] + nums[i];
        }
// DP using skip and take
        int skip = 0;
        int take = 0;
        for (int i = 0; i < max + 1; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);
    }
}
