/***
 Using house robber approach
 TC - O(n), SC - O(n)
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[10001];

        int prev1 =0;
        int prev2 =0;

        //calculate the sum of same elements
        for(int num : nums) {
            dp[num] += num;
        }

        for(int num : dp) {
            int tmp = prev1;
            prev1 = Math.max(prev2+ num, prev1);
            prev2 = tmp;
        }

        return prev1;
    }
}
