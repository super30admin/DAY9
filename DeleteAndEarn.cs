// time complexity - O(m+n) where n = length of nums and m = max value in nums
// space complexity - O(m) where m = max calue present in nums
public class Solution
{
    public int DeleteAndEarn(int[] nums)
    {
        int n = nums.Length;
        int maxVal = int.MinValue;
        for (int i = 0; i < n; i++)
        {
            maxVal = Math.Max(maxVal, nums[i]);
        }
        Console.WriteLine(maxVal);
        int[] numsVal = new int[maxVal];
        for (int i = 0; i < n; i++)
        {
            numsVal[nums[i] - 1] += nums[i];
        }
        if (numsVal.Length == 1)
        {
            return numsVal[0];
        }
        // int[] dp = new int[maxVal];
        // dp[0]= numsVal[0];
        // dp[1]= Math.Max(dp[0],numsVal[1]);
        int prev = numsVal[0];
        int curr = Math.Max(prev, numsVal[1]);

        for (int i = 2; i < maxVal; i++)
        {
            //dp[i] = Math.Max(dp[i-1],numsVal[i]+dp[i-2]);
            int tmp = curr;
            curr = Math.Max(curr, numsVal[i] + prev);
            prev = tmp;
        }
        //return dp[maxVal-1];
        return curr;
    }
}