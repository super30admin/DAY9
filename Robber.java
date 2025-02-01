// Memoiaztion 
//Time complexity o(n)
// space complexity o(n)

// import java.util.Arrays;

// class Solution {
//     int [] memo;
//     public int rob(int[] nums) {
//         this.memo = new int [nums.length];
//         Arrays.fill(memo, -1);
        
//         return helper(nums, 0);
//     }

//     private int helper(int[] nums, int idx){
//         // base case
//         if(idx >= nums.length) return 0;
//         if(memo[idx] != -1) return memo[idx];
//         //logic
//         int case1 = helper(nums, idx+1);

//         int case2 = nums[idx] + helper(nums, idx+2);
//         int re = Math.max(case1, case2);
//         memo[idx] = re;
//         return re;
//     }
// }

// Dp solution 
//Time complexity o(n)
// space complexity o(n)

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int [] dp = new int[n];

//         dp[0] = nums[0];
//         if(n==1) return dp[0];
//         dp[1] = Math.max(dp[0],nums[1] + 0);

//         for(int i = 2; i<n;i++){
//             dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }

//using variables
// Time complexity o(n)
// space complexity o(n)

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //int [] dp = new int[n];

        int prev = nums[0];
        if(n==1) return prev;
        int curr = Math.max(prev,nums[1] + 0);

        for(int i = 2; i<n;i++){
            int temp = curr;
            curr = Math.max(temp, nums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}