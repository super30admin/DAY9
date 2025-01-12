//TC: O(max)
//SC: O(max)
//approach: dynamic programming
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }

        int a[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] += nums[i];
        }

        int dp[][] = new int[max + 1][2];
        dp[1][1] = a[1];
        for (int i = 2; i < max + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = a[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
        }
        return Math.max(dp[max][0], dp[max][1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2};
        System.out.println(deleteAndEarn(nums));
    }
}
