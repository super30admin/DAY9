// Time Complexity : O(n)  where n is the max value in the input nums
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


public class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max)
                max = n;
        }
        int[] maxcounts = new int[max+1];

        for (int n : nums) {
            maxcounts[n] += n;
        }

        int prev = maxcounts[0];
        int curr = maxcounts[1];

        for (int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + maxcounts[i]);
            prev = temp;
        }

        return curr;

    }
}