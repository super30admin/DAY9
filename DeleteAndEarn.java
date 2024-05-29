//Time complexity: O(max(n, max element))
//Space complexity: O(max element)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        
        //fill the dp array with the sum of the elements at the index of the element
        for(int i = 0;i<nums.length;i++){
            int index = nums[i];
            dp[index] = dp[index] + index;
        }

        int skip = 0;
        int take = dp[0];
        for(int i = 1; i<max+1;i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip, take);
    }
}


