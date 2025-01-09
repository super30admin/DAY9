// Time Complexity : O(n+max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
        }
        int [] dp = new int[max+1];
        for(int i=0;i<nums.length;i++){
            int index=nums[i];
            dp[index]=dp[index]+nums[i];
        }
        int skip=0;
        int take=0;
        for(int i=1;i<max+1;i++){
            int tempSkip = skip;
            skip=Math.max(skip, take);
            take=tempSkip+dp[i];
        }
        return Math.max(skip,take);
    }

    public static void main(String[] args) {
        int [] nums = { 3,4,2};
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }
}