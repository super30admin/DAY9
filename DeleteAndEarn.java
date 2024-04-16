// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Time complexity = O(n )+O(max(n)
//Space = O(1)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n ==1) return nums[0];

        int max=0;
        for(int i=0;i< n;i++) {
            max = Math.max(max,nums[i]);
        }

        int[] arr = new int[max+1];
        for(int i=0;i<n;i++){
            arr[nums[i]] += nums[i];
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i=2;i<=max;i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i]+prev);
            prev = temp;
        }

        return curr;
    }
}