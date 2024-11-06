// Time Complexity : O(m+n) where n is number of elements and m is largest element
// Space Complexity : O(m) for points map and dp array
// Ran on LeetCode : yes
// Any Problems : No
public class DeleteAndEarn {
    public int deleteAndEarn(int [] nums){
        if(nums.length == 0) return 0;

        // Find the max value in the array
        int maxValue = 0;
        for (int num : nums){
            maxValue = Math.max(num, maxValue); // this will give us the maximum value in the given array
        }
         // create the points array which will have Frequency of each element

        int[] points = new int[maxValue +1]; // size of array is equal to maxValue +1
        for (int num : nums){
            points[num] += num;
        }
        // create a dp array
        int[] dp = new int[maxValue +1];
        dp[0] = 0;
        dp[1] = points[1];
        for (int i=2;i<=maxValue;i++){
            dp[i] = Math.max(dp[i-1], points[i]+ dp[i-2]);
        }
        return dp[maxValue];
    }

    public static void main(String[] args){
        DeleteAndEarn delete = new DeleteAndEarn();
        int [] nums = {2,2,3,3,3,4};
        int maxAmount = delete.deleteAndEarn(nums);

        System.out.println(maxAmount);

    }
}
