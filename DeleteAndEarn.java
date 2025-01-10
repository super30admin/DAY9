class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max + 1];

        for(int i=0;i<nums.length; i++){
            int index = nums[i];
            dp[index] += nums[i];
        }

        int skip=0, take=0;
        for(int i=0;i<dp.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }

        return Math.max(skip, take);
    }
}
