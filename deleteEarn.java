/*
This question is similar to house robber probelm where adjaccent elements cannot be same
int[] array = [0,2,3,1] for indexes 0,1,2,3 for the problem  
0 1 approach 
  0  1
2 0  4 
3 4  9 
4 9  8
TC --> O(n) 
SC --> O(n) for the array
 */
class Solution {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int max_val = nums[n];
        int[] arr = new int[max_val + 1];
        for (int i = 0; i < nums.length; i++) {

            arr[nums[i]] += 1;

        }//for

        // for(int i=0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }//for
        int[][] dp = new int[max_val + 1][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = arr[i] * i + dp[i - 1][0];

        }//for

        return Math.max(dp[max_val][0], dp[max_val][1]);

    }//method
}//class
