// Time Complexity :Omax((max(nums), nums.length))
// Space Complexity :O(maximum number)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//found the max
//created an array with max number of elements
//added the sum of each numbers in the input at the number index
//Space: O(maximum number)
//time: Omax((max(nums), nums.length))

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length<2) return nums[0];
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max=Math.max(num, max);
        }
        int[] arr= new int [max+1];
        for(int num: nums){
            arr[num] += num; 
        }
        //array which can be used like house robber
        int prev = arr[0];
        int current = arr[1];
        for(int i = 2; i < arr.length; i++){   //O(maximum of array)
            int temp = current;
            current=Math.max(current, prev+arr[i]);
            prev=temp;
        }
        return current;
    }
}