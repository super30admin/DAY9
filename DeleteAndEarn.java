// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int[] pnums = new int[max+1];
        for(int num : nums) {
            pnums[num] += num;
        }
        int pn = pnums.length;

        int[] dp = new int[pn+1];
        dp[0] = pnums[0];
        dp[1] = Math.max(dp[0], pnums[1]);

        for(int i=2; i<pn; i++) {
            dp[i] = Math.max(dp[i-1], pnums[i] + dp[i-2]);
        }
        return dp[pn-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
}