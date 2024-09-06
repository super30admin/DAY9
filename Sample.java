// Time Complexity : O(2^m)    m=maximum element of array
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes, time limit exceed
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

Delete and Earn

class Solution {
    private int helper(int[] arr, int idx){
        //base
        if (idx >= arr.length)
            return 0;
        
        //logic
        //choose
        int case1 = arr[idx] + helper(arr, idx+2);

        //don't choose
        int case2 = 0 + helper(arr, idx+1);

        return Math.max(case1, case2);
    }
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num] += num;
        }
        return helper(arr, 0);
    }
}



// Time Complexity : O(n+m)   n=number of elements, m=maximum element of array
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

Delete and Earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2;i<=max;i++){
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}


