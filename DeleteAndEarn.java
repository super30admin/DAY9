/**
 L.C 740

 Approach: Using dynamic programming with 0,1 approach

 Working:
     Find max in input array create a dp array of max size
     Fill the dp array with the sum of all the value for an index in input array
     Now perform the 0,1 approach, adjacent elements cannot be selected
     0 - skip // max previous 0 and 1 i.e skip and take
     1- take //sum of previous skip and current earning in the dp array

 ret max of skip/take to obtain the maximum earning

 Time Complexity: O(max(n, maxElement))
 Space Complexity: O(maxElement)
 */

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int[] dp = new int[max+1];

        for(int i=0; i<nums.length; i++){
            dp[nums[i]] += nums[i];
        }

        int skip = 0;
        int take = dp[0];
        for(int i=1;i<dp.length; i++){

            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + dp[i];
        }
        return Math.max(skip,take);

    }
}