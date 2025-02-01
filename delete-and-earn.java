// Time Complexity :O(m+n) // m is max of nums array
// Space Complexity : O(m) // m is max of nums array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i have tried greedy approach but it's failing in some cases so for exhaustive solution i am unable to do choose and not choose scenrio with given data because i need to hide nums[i]+1 and nums[i]-1 in the case 
// i have used anthoer array which is the length of maximun elemnt in nums array then it seems like house robber problem it self so ihave used memization approach by taking 1d array of size max of nums array 

class Solution {
    public int deleteAndEarn(int[] nums) {
     int n = nums.length;
     int max=Integer.MIN_VALUE;
     for(int i=0;i<n;i++){
        max=Math.max(max,nums[i]);
     }
     int[] arr=new int[max+1];
     for(int i=0;i<nums.length;i++){
        arr[nums[i]] += nums[i];
       
     }
      arr[1] = Math.max(arr[0],arr[1]+0);
     for(int i=2;i<arr.length;i++){
      arr[i] = Math.max(arr[i-1],arr[i]+arr[i-2]);       
     }
     return arr[max];
}
}



// solution-2
// Time Complexity :O(m+n) // m is max of nums array
// Space Complexity : O(m) // m is max of nums array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: i have tried greedy approach but it's failing in some cases so for exhaustive solution i am unable to do choose and not choose scenrio with given data because i need to hide nums[i]+1 and nums[i]-1 in the case 
// i have used anthoer array which is the length of maximun elemnt in nums array then it seems like house robber problem it self so ihave used memization approach by taking 1d array of size max of nums array 

class Solution {
    public int deleteAndEarn(int[] nums) {
     int n = nums.length;
     int max=Integer.MIN_VALUE;
     for(int i=0;i<n;i++){
        max=Math.max(max,nums[i]);
     }
     int[] arr=new int[max+1];
     for(int i=0;i<nums.length;i++){
        arr[nums[i]] += nums[i];
     }
     System.out.println("="+Arrays.toString(arr));
    int prev=arr[0];
     int current = Math.max(arr[0],arr[1]+0);
     for(int i=2;i<=max;i++){
        int temp=current;
        current = Math.max(current,arr[i]+prev);   
        prev=temp;    
     }
     return current;
}
}