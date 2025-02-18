// Time Complexity : O(n+k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        //To find the max element
        int max=Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int [] arr=new int[max+1];
        for(int i=0;i<n;i++){
            int curr=nums[i];
            arr[curr]+=curr;
        }
        // house robber
        int prev =arr[0];
        int curr=Math.max(arr[0],arr[1]);
        for(int i =2;i<arr.length;i++){
            int temp=curr;
            curr=Math.max(curr,arr[i]+prev);
            prev=temp;
        }
        return curr;
    }
}