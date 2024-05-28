
// Time Complexity : max of (o(n), largest element)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//  find the maximum of the array by iterating through it.
// create new array of lenth max +1;
// iterate through given array to see if each number from index 0 exists.
// and copy t to the new array if exists. if the number repeats add it to the existing element in the  new array
// take two variable skip and take
//first skip is 0 as we didnt pick anything
//store this skip in tempSkip
// calculate subsequent skip.  is max of previous skip and take.
//take = tempskip + current element from dp.
// at the end return the max of skip and take.
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] dp = new int [max+1];
        for(int i=0; i<nums.length;i++){
            int index = nums[i];
            dp[index ]= dp[index] + index;
        }
        int skip = 0;
        int take = dp[0];
        for(int i=1; i<max+1; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip+ dp[i];
        }
        return Math.max(skip,take);


    }
}
