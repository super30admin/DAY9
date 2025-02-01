//Time complexity o(max(n)+n) , o(m+n)
//Space complexity o(m), depends on max of n

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        for(int i =0; i<n;i++){
            max = Math.max(max, nums[i]);
        }
        int [] arr = new int[max+1];
        for(int i=0;i<n;i++){
            int curr = nums[i];
            arr[curr] += curr;
        }
        int prev = arr[0];
        int curr = Math.max(prev, arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp = curr;
            curr = Math.max(temp,arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}