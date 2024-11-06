//Time Complexity : O(m+n) where n is number of elements and m is largest element
// Space Complexity : O(m) for points array
// Ran on LeetCode : yes
// Any Problems : No
public class DeleteAndEarnWithoutDp {
    public int deleteAndEarn(int [] nums){
        if(nums.length == 0) return 0;
        // find the maxValue
        int maxValue =0;
        for (int num: nums){
            maxValue = Math.max(num, maxValue);
        }
        // create the points array
        int []points = new int[maxValue+1]; // create points array of size maxValu +1
        for(int num : nums){
            points[num]+= num;
        }

        int prev2 = 0;         // dp[i-2]
        int prev1 = points[1]; // dp[i-1]
        for (int i=0; i <= maxValue; i++){
            int current = Math.max(prev1, points[i]+prev2);
            prev2= prev1;
            prev1 = current;
        }
        return prev1;

    }

    public static void main(String []args){
        DeleteAndEarnWithoutDp dpW = new DeleteAndEarnWithoutDp();
        int [] nums = {2,2,3,3,3,4};
        int maxAmount = dpW.deleteAndEarn(nums);

        System.out.println(maxAmount);

    }
}
