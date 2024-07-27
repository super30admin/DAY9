// Time Complexity : O(nm)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = -9999;
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        int[] sumArray = new int[max+1];
        for(int i=0 ; i<=max; i++) {
            for(int j=0 ; j<nums.length ; j++) {
                if(nums[j] == i) {
                    sumArray[i] += nums[j];
                }
            }
        }
        
        int prev = sumArray[0];
        int curr = Math.max(sumArray[0], sumArray[1]);
        for(int i=2 ; i<= max; i++) {
            int temp = curr;
            curr = Math.max(sumArray[i]+prev, curr);
            prev = temp;
        }
        return curr;
    }
}