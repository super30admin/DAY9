//TC:O(N + M) ≈ O(N)  M is at most 10⁴ and N can be 2 × 10⁴
//SC:O(M) ≈ O(1) 


class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        // Step 1: Create points array
        int[] points = new int[maxNum + 1];
        for (int num : nums) {
            points[num] += num;
        }
        
        // Step 2: Apply DP (Similar to House Robber)
        int prev2 = 0, prev1 = 0;
        for (int i = 0; i <= maxNum; i++) {
            int curr = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}