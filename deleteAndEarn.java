// Time Complexity : O(n+m) n-nums array size, m - max
// Space Complexity :O(m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        System.out.println(max);
        for(int num:nums){
            max=Math.max(max,num);
        }
        int []arr = new int[max+1];
        for(int num:nums){
            arr[num]+=num;
        }
        int prev = arr[0];
        int curr = Math.max(prev,arr[0]+arr[1]);
        for(int i=2;i<=max;i++){
            int temp=curr;
            curr=Math.max(curr,prev+arr[i]);
            prev=temp;
        }

        return curr;
    }
}