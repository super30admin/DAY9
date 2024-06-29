// Time Complexity : O(m+n)  => maximum of m and n
// Space Complexity : O(m)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }

        int prev = arr[0];
        int curr = Math.max(arr[1], prev);

        for (int i = 2; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }

        return curr;

    }
}