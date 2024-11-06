// Time Complexity : O(n) as it uses single for loop to iterate over all elements
// Space Complexity : O(n) due to dp array
// Ran on LeetCode : yes
// Any Problems : No

public class RobHouses {
    public int robHouse(int [] nums){

        if(nums.length ==0) return 0;
        if(nums.length ==1) return nums[0];
        int n = nums.length;

        // create a dp array
        int [] dp = new int[n];

        // fill the DP Array
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i =2; i<n; i++){ // return max of choose and no choose cases
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); // 1. no choose case is one above and 2. choose case is current + alternate- leaving one case -(1-2)
        }
        return dp[n-1];
    }

    public static void main (String [] args){
        RobHouses rob = new RobHouses();
        int [] nums = {2,7,9,3,1};
        int maxAmount = rob.robHouse(nums);

        System.out.println(maxAmount);

    }
}
