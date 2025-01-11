public class DeleteAndEarn {
    //time complexity: O(n)
    //space complexity: O(n)
    //thought process:
    //1. create a dp array to store the maximum points that can be earned by deleting the element at index i
    //2. iterate through the nums array and update the dp array
    //3. return the maximum points that can be earned by deleting the element at index i
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length ==0){
         return 0;
        } 
        int max = 0;
        for (int i =0; i< nums.length; i++){
         max = Math.max (max, nums[i]);
        }
 
        int[] dp = new int [max+1];
 
        for (int i =0; i< nums.length;i++){
         int index = nums[i];
         dp[index] = dp[index] + nums[i];
        }
        int skip = 0;
        int take = 0;
        for (int i = 1; i< max +1;i++){
         int tempSkip = skip;
         skip = Math.max (skip, take);
         take = tempSkip + dp[i];
        }
        return Math.max (skip,take);
     }
 
}
