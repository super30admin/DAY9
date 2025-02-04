// Time Complexity : O(N)+O(N)+O(M)=O(N+M)
//Since M is the maximum element in nums, this complexity depends on both the length of nums and the largest number present.
// Space Complexity : O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DeleteAndEarn {

    public static void main(String[] args)
    {
//        int[] nums = {3, 4,2};
        int[] nums = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }

    private static int deleteAndEarn(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] arr = new int[max + 1];

        for(int num : nums) {
            arr[num]++;
        }

        int prev = arr[0];
        int curr = Math.max(arr[1], arr[0]);

        for(int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, i*arr[i] + prev);
            prev = temp;
        }

        return curr;
    }
}
