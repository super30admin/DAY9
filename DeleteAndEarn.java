// Time Complexity : O(max(n, maxElement)
// Space Complexity : O(maxElement)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class DeleteAndEarn {
        public int deleteAndEarn(int[] nums) {
            if(nums== null || nums.length ==0){
                return -1;
            }
            int n = nums.length;
            int max =0;
            for(int i=0;i<n;i++){
                max = Math.max(max, nums[i]);
            }

            int[] dp = new int[max+1];
            for(int i=0;i<n;i++){
                int index = nums[i];
                dp[index] = dp[index] + index;
            }

            int skip =0;
            int take = 0;
            for(int i=1;i<max+1;i++){
                int tempSkip = skip;
                skip = Math.max(tempSkip, take);
                take = tempSkip + dp[i];
            }
            return Math.max(skip, take);
        }
}
