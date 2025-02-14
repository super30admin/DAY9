// ## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Time Complexity : O(Exponential)
// Space Complexity : O(N) --> Recursive stack space
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Try out all possible ways


class Solution {
    // Brute Force - 01 Recursion (void based)
    // TO(2^N), SO(N - Recursive stack space)

    int max;

    private void bruteForce(int[] arr, int idx, int points){
        //base
        if(idx>=arr.length){
            max=Math.max(max, points);
            return;
        }

        // skip all the zero elements
        if(arr[idx]==0){
             bruteForce(arr, idx+1, points);
             return;
        }

        //logic
        // chose:
        // delete the current one and eliminate elements equal to nums[idx]+1
        // ie, jump ahead by 2 steps
        // increment the points
        bruteForce(arr, idx+2, points + arr[idx]);

        // not chose:
        // skip the current element, idx increments by 1, points remain same
        bruteForce(arr, idx+1, points);
    }

    private int[] preprocess(int[] nums){
        int[] processed = new int[10000]; // max size from constraints
        for(int i=0;i<nums.length;i++){
            processed[nums[i]] += nums[i];
        }

        return processed;
    }

    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)  return nums[0];

        // Make a consolidated array with freq*value,
        // as we are considering all elements with same value together
        int[] consolidated = preprocess(nums);

        max=0;
        bruteForce(consolidated, 0, 0);
        return max;
    }
}
