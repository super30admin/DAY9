// Time Complexity :O(n+k) K is maximum value in nums
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Step 1: Use a frequency map to sum up all occurrences of each number
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // Step 2: Apply the "House Robber" dynamic programming solution
        int prev1 = 0, prev2 = 0;
        for (int i = 0; i < points.length; i++) {
            int current = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
    
}
