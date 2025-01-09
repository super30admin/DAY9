/**
 * Time complexity: O(max(n, max element)) = O(n + maxElement)
 * Space complexity: O(maxElement)
 * Ran on leetcode? Yes
 * Issues faced? No
 *
 * Approach: Approach:
 *  - Greedy fails here if the array is like 2,8,9,8,1,5
 *  - First reduce the solution into house robber solution
 *  - Apply DP
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int[] newNums = new int[max + 1];
        for (int n : nums) {
            newNums[n] += n;
        }

        int prev = 0;
        max = 0;

        for (int num : newNums) {
            int temp = Math.max(max, prev + num);
            prev = max;
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {2,1,2,3,4,5,5,3,4};
        int result = obj.deleteAndEarn(nums);
        System.out.println("Result: " + result);
        assert(result == 17);
    }
}
