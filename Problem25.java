// Time Complexity: O(n+k)
// Space Complexity: O(k)
// Delete and Earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxNum = Arrays.stream(nums).max().getAsInt(); // Find the maximum number in nums
        
        // Frequency array to count occurrences of each number
        int[] frequency = new int[maxNum + 1];
        for (int num : nums) {
            frequency[num]++;
        }
        
        // DP array to store the maximum points up to each number
        int[] dp = new int[maxNum + 1];
        
        // Base cases
        dp[0] = 0;
        dp[1] = frequency[1];
        
        // Fill the DP array based on the state transition
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + i * frequency[i]);
        }
        
        return dp[maxNum];
    }
}
