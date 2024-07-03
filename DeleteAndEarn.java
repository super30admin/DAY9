/**
 * Time Complexity - O(n + m)
 *  - n is the length of the input array nums
 *  - m is the maximum number in the nums array
 */

/**
 * Space Complexity - O(m)
 * Size of countFrequency which is the maximum number of the array
 */



class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for(int num: nums) {
            maxNumber = Math.max(maxNumber, num);
        }
        int[] countFrequency = new int[maxNumber + 1];
        for(int i= 0;i< nums.length; i++) {
            countFrequency[nums[i]] += 1;
        }
        int[] dp = new int[maxNumber + 1];
        dp[1] = countFrequency[1];
        for(int i = 2; i <= maxNumber; i++) {
            dp[i] = Math.max(dp[i-1], dp[i - 2] + i * countFrequency[i]);

        }
        return dp[maxNumber];

    }
}
