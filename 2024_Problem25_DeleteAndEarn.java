//740. Delete and Earn - https://leetcode.com/problems/delete-and-earn/description/
//Time Complexity: O(n) + O(max(n)) ~ O(n)
//Space Complexity: O(maxLength)

class Solution {
    public int deleteAndEarn(int[] nums) {
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;;
        //find the max element to consider the same as length of array to parse over
        for(int num : nums){
            maxLength = Math.max(maxLength, num);
        }
        //create array of size maxLength+1
        int[] arr = new int[maxLength+1];
        //store the elements to their corresponding indexes
        for(int num: nums){
            arr[num] = arr[num] + num;
        }
        //similar to House Robber solution on arr
        int prev = arr[0];
        int curr = Math.max(prev, arr[1]);
        for(int i=2; i<=maxLength; i++){
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }
        return Math.max(prev, curr);
    }
}