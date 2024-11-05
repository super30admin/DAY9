// Time Complexity : the time complexity will be O(n) [ find the max element] + O(n) [ add the values into the values array] + O(n)[dp to find the max value that can be earned]
// Space Complexity : The space complexity will be O(n) since we are maintaining a separate array to maintain the values that could be formed with each entry in the given array. that is the frequency of the elements.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No. 

public class DeletenEarn {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxNumber = Math.max(maxNumber,nums[i]);
        }
        int[] value = new int[maxNumber+1];
        for(int i=0; i<nums.length; i++){
            value[nums[i]]+=nums[i];
        }
        
        int a=0,b=0;
        for(int i=0; i<value.length; i++){
            int temp = b;
            b = Math.max(value[i] + a, b);
            a = temp;
        }
        return b;   
    }
}