// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes

import java.util.Arrays;

public class deleteEarn {
    public int deleteAndEarn(int[] nums) {
         int max = Arrays.stream(nums).max().getAsInt();

         int[] dp= new int[max+1];

         for(int num: nums){
             dp[num] += num;
         }

         int prev = nums[0];
         int curr = Math.max(nums[0], nums[1]);

         for(int i=2; i<nums.length; i++){
             int temp= curr;
             curr= Math.max(curr, prev+nums[i]);
             prev= temp;
         }

         return curr;
    }


    public static void main(String args[]) {
        deleteEarn deleteEarn = new deleteEarn();
        int[] nums={2,2,3,3,3,4};
        System.out.println("Output "+ deleteEarn.deleteAndEarn(nums));

    }
}
