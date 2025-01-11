// Time Complexity :O(max(n,maxElement))
// Space Complexity :O(maxElement)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
public class Problem2 {
    //we're going to use house robber pattern but first we've make our nums array converted into that.
    //create another array which contains the index as the elements in num and value at that index would be total sum of that element incomming in the original nums array.
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;

        //find max element so we can create array of that length
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(nums[i],max);
        }

        int[] auxilaryArray = new int[max+1];
        //now store the value in the array
        for(int i = 0;i<n;i++){
            int index = nums[i];
            auxilaryArray[index] = auxilaryArray[index] + nums[i];
        }

        //this is house robber pattern now
        int skip = 0;
        int del = 0;
        for(int i=1;i<max+1;i++){
            int tempSkip = skip;
            skip = Math.max(skip,del);
            del =  auxilaryArray[i] + tempSkip;
        }

        return Math.max(skip,del);
    }
}
