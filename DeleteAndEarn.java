public class DeleteAndEarn {
   /* 2,1,8,1,2,4,4,6,4,7,3,3   i/p
    2,4,6,12,0,6,14,8    optimize
    1,2,3, 4,5,6, 7,8*/
   public int deleteAndEarn(int[] nums) {
       if(nums==null || nums.length==0) return 0;
       int n=nums.length;
       int max=Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
           max=Math.max(max,nums[i]);
       }
       //optimization array
       int[] arr=new int[max+1];
       for(int i=0;i<n;i++){
           int curr=nums[i];
           arr[curr]=arr[curr]+curr;
       }
       int prev=arr[0];
       int curr=Math.max(arr[0],arr[1]);
       for(int i=2;i<arr.length;i++){
           int temp=curr;
           curr=Math.max(curr,arr[i]+prev);
           prev=temp;
       }
       return curr;
   }

}
