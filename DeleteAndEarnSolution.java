class DeleteAndEarnSolution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        int take = 0, skip = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            dp[index] = dp[index] + index;
        }
        for (int i = 1; i < max + 1; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);
    }
}