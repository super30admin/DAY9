class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max=-99999;
      
        for(int i=0;i<nums.length;i++){
          max=Math.max(nums[i],max);
        }
        int arr[] = new int[max+1];
       for(int i=0;i<nums.length;i++){
        arr[nums[i]]+=nums[i];
       }
       arr[1]=Math.max(arr[0],arr[1]);
       int t=arr[1];
       for(int i=2;i<=max;i++){
        arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
        t= Math.max(t,arr[i]);
       }
         return t;
        }
        


    }
