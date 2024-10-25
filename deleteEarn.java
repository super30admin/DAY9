// Time Complexity : O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

// Used two variable for optimizing the solution

public class deleteEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for (int num : nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;
    }
}
