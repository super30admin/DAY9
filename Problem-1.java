// Time Complexity : O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max =0;
        for(int i = 0;i < nums.length; i ++){   //O(n)
            max = Math.max(max, nums[i]);
        }


        //build an array with their sum
        int [] array = new int[max + 1]; //O(max(n))
        for(int i = 0;i < nums.length; i ++){
            array[nums[i]] += nums[i];
        }

        int prev = array[0];
        int cur = Math.max(prev, array[1]);

        for(int i =2; i < array.length; i++){
            int temp = cur;
            cur = Math.max(cur, array[i] + prev);
            prev = temp;
        }
        return cur;
    }
}