// Time Complexity: O(Max of n, k) where n is length of nums and k is maximum point in the array.
// Space Complexity: O(k) where k is the maximum point
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
    }
    int[] dp = new int[max + 1];
    for (int i = 0; i < nums.length; i++) {
      int index = nums[i];
      dp[index] += nums[i];
    }
    int skip = 0;
    int take = 0;
    for (int i = 1; i <= max; i++) {
      int tempSkip = skip;
      skip = Math.max(skip, take);
      take = tempSkip + dp[i];
    }
    return Math.max(skip, take);
  }
}
