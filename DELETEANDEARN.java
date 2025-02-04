class Solution {
    public int deleteAndEarn(int[] nums) {
        int n= nums.length;
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int[] arr=new int[max+1];
        for(int i=0;i<n;i++){
            arr[nums[i]]+=nums[i];
        }
        int prev=arr[0];
        int curr=Math.max(prev,arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp=curr;
            curr=Math.max(curr,arr[i]+prev);
            prev=temp;
        }
        return curr;
    }
}