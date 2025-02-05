// Overall Time Complexity : O(n) . The n is number of elements in the array .
// Overall Space Complexity : O(max(n,max_value)) . The space complexity is the maximum size of the given array and the auxillary computed array.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


// This solution calculates the maximum points that can be earned by deleting elements from the array.  
// Create a new array where each index stores the total sum of occurrences of that value in the original array.  
// We then follow the House Robber pattern to decide whether choosing or skipping a value yields the maximum result.  


class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null|| nums.length ==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int []arr = new int[max+1];

        for(int i=0; i<n;i++){
            int curr = nums[i];
            arr[curr] += curr;

        }
        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for(int i=2; i<arr.length;i++){
            int temp = curr;
            curr = Math.max(curr, arr[i]+prev);
            prev = temp;
        }
        return curr;
    }
}
