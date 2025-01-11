// TC: O(MAX(n, x)), where x is the maximum Element in the input array & n is the length of input array.
// SC: O(x)

public class LC740 {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = 0;
        int n = nums.length;
        for(int x:nums){
            max = Math.max(x, max);
        }
        int dp[] = new int[max+1];
        for(int i=0;i<n;i++){
            int num = nums[i];
            dp[num] += num;
        }
        for(int i=1;i<=max;i++){
            int p = dp[i];
            if(i>2) p += dp[i-2];
            int np = 0;
            if(i>1) np += dp[i-1];
            dp[i] = Math.max(p, np);
        }
        return dp[max];
    }
}