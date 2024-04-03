// Time complexity: O(n + max(nums)), where n is the length of the input array nums and max(nums) is the maximum element in nums.
// Space Complexity: O(max(nums)), as we create an array of size max(nums) + 1.
// Approach: We first find the maximum element in nums to determine the size of the array needed. We then iterate through nums twice: first to fill the array with the sum of values at their respective indices and second to apply the house robber algorithm to find the maximum sum without adjacent elements. Finally, we return the maximum sum calculated using the house robber algorithm.
// LeetCode Link: https://leetcode.com/problems/delete-and-earn/

class Solution {
    public int deleteAndEarn(int[] nums) {
    //null
    if(nums== null || nums.length==0) return 0;
    int max= Integer.MIN_VALUE;
    for(int num:nums) //O(n) + O(max(nums))
    {
        max = Math.max(max, num);
    }
    int[] arr = new int[max+1];
    for(int num:nums) //O(n)
    {
        arr[num]+=num; //sc= O(max(nums))
    }
    //arr->house robber
    int prev = arr[0];
    int curr= arr[1];
    for(int i=2; i<arr.length; i++)
    { //O(max(nums))
        int temp = curr;
        curr= Math.max(curr, prev+arr[i]);
        prev = temp;
    }
    return curr;
    }
}