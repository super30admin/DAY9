// Time Complexity: Using 2D array: O(n) as array in traversed. Using Vars: O(n) as array is traversed.
// Space Complexity: Using 2D array: O(n) as 2d is utilized for dp. Using Vars: O(1) as only variables are used.

// Solved with 2 approaches similar to House Robber.
public class DeleteandEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarnUsingArray(new int[] { 3, 4, 2 })); // 6
        System.out.println(deleteAndEarnUsingArray(new int[] { 2, 2, 3, 3, 3, 4 })); // 9
        System.out.println(deleteAndEarnUsingArray(new int[] { 0 })); // 0

        System.out.println(deleteAndEarnUsingVars(new int[] { 3, 4, 2 })); // 6
        System.out.println(deleteAndEarnUsingVars(new int[] { 2, 2, 3, 3, 3, 4 })); // 9
        System.out.println(deleteAndEarnUsingVars(new int[] { 0 })); // 0
    }

    // Calculated the max elements. Created array and increments the index positions
    // by values of nums[i]. Based on adjacent positions consideration or not, dp
    // approach is used.
    private static int deleteAndEarnUsingArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int numArray[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            numArray[nums[i]] += nums[i];
        }
        int dp[][] = new int[numArray.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < numArray.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + numArray[i];
        }
        return Math.max(dp[numArray.length - 1][0], dp[numArray.length - 1][1]);
    }

    // Calculated the max elements. Created array and increments the index positions
    // by values of nums[i]. Based on adjacent positions consideration or not, The
    // sum is carry forward.
    private static int deleteAndEarnUsingVars(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int numArray[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            numArray[nums[i]] += nums[i];
        }

        int skip = 0;
        int consider = 0;
        for (int i = 1; i < numArray.length; i++) {
            int skipTemp = skip;
            skip = Math.max(skip, consider);
            consider = skipTemp + numArray[i];
        }
        return Math.max(skip, consider);
    }
}
