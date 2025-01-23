// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//We aggregate sum same numbers and treat this like a house robber dp problem
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num]+=num;
        }
        int[][] dp = new int[max+1][2];
        for(int i = 1 ; i <= max; i++){
            dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = arr[i] + (i-2 >= 0 ? Math.max(dp[i-2][0],dp[i-2][1]):0);
        }
        return Math.max(dp[max][0],dp[max][1]);    
    }
}
