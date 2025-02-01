// Problem1: (https://leetcode.com/problems/delete-and-earn/)

// Time Complexity : O(m+n), max(m,n)
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * In this problem, dynamic programming is implemented where first find the new array with sum of elements of same type at the index as element.
 * Then using the 2 variables named prev and curr. curr variable will be moved across thearray from left ro right. prev would be 0th index element
 * at start and curr would be max of prev index element and element at curr index, for all the elements later curr is max of prev, prev + element
 * at that index will be taken and prev is moved to previous curr. The curr variable is returned.
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
           max = Math.max(max, nums[i]);
        }
        int arr[] = new int[max+1]; //since we need till number max from 0
        for(int i = 0; i<n;i++){
            int curr = nums[i];
            arr[curr]+=curr;
        }
        //house robber problem for arr
        int prev = arr[0];
        int curr = Math.max(prev,arr[1]);
        for(int i = 2;i<arr.length;i++){
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
}