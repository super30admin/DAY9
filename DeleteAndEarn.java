//time - O(max of maxElement, size of the array nums), space - O(maxElement)
/*consider test case [1,100]. In this case the n is 2 but the maxElement is 100 which means we will be creating and iterating over an array of ///size 100. This is why time complexity is max between maxElement, size of the array nums
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxNumber = 0;

        for(int n : nums){
            maxNumber = Math.max(maxNumber, n);
        }

        int[] sumOfNumbers = new int[maxNumber+1];

        for(int n : nums){
            sumOfNumbers[n] += n;
        }

        int[][] dp = new int[sumOfNumbers.length+1][2];

        for(int i=1; i<dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + sumOfNumbers[i-1];
        }

        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}