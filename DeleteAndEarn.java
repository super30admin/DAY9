// dp programming.
// Space complexity = O(n)
// Time complexity = O(n)
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num:nums) {
            max = Math.max(max,num);
        }
        int[] arr = new int[max+1];
        for(int num: nums) {
            arr[num] += num;
        }
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2; i< arr.length; i++ ) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);// 1 step before or 2 steps before.
            prev = temp;
        }
        return curr;
    }
}