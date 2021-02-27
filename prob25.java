//tc:O(n)

//sc:O(n)

class Solution {
    public int deleteAndEarn(int[] nums) {
        if( nums == null || nums.length ==0){
            
            
    return 0;
            
        }
        int[]dp  = new int[getMax(nums) +1];
        
        for(int x: nums)
            dp[x] +=x;
        
        int c =0;int dc=0;
        for(int x: dp){
            int temp = dc;
            dc = Math.max(c,dc);
            c= temp + x;
        }
        return Math.max(c,dc);
    }
    private int getMax(int[] nums){
        int max= Integer.MIN_VALUE;
        for(int x: nums){
            if(x > max)
                max = x;
        }
        return max;
    }
}