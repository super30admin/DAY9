// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
Pre-process the given input in a way to arrange the values in input array to the sum of the same values
in another array and store those at the same value's index. From here, it is same as house robber.
 */
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) { //O(n) T.C
            max = Math.max(max, num); //Finding the max value from input
        }

        int[] pnums = new int[max+1];
        for(int num : nums) {
            pnums[num] += num; //Assigning the sum of same values in input to that specific value's index
        }
        int pn = pnums.length;

        int[] dp = new int[pn+1]; // Below is same as house robber
        dp[0] = pnums[0];
        dp[1] = Math.max(dp[0], pnums[1]);

        for(int i=2; i<pn; i++) { //O(n) T.C
            dp[i] = Math.max(dp[i-1], pnums[i] + dp[i-2]); //O(n) S.C
        }
        return dp[pn-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }
}
