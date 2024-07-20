//With Dynmaic Programming

//Time = O(N)
//space = O(1)
class Solution {
    public int deleteAndEarn(int[] nums) {
        // Create an array to store the frequency of each number in nums
        int[] freq = new int[10001];
        for (int n : nums) {
            freq[n]++;
        }
        
        // Initialize variables to keep track of the maximum score earned up to the previous and current numbers
        int prevMax = 0, currMax = 0;
        
        // Iterate over the numbers from 1 to 10000
        for (int i = 1; i <= 10000; i++) {
            int temp = currMax; // Temporary variable to store the current value of currMax
            
            // Calculate the maximum score that can be earned up to the current number
            currMax = Math.max(prevMax + i * freq[i], currMax);
            // If we delete all instances of i, the score earned would be prevMax + i * freq[i].
            // If we keep all instances of i, the score earned would be currMax.
            // We choose the maximum of these two values as the new value of currMax.
            
            prevMax = temp; // Update prevMax to the previous value of currMax
        }
        
        return currMax; // Return the maximum score earned
    }
}
