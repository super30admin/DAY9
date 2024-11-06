// We optimise the space complexity to use constant space by not using DP
public class RobHousesNoDP {
    public int robHouse( int [] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev2 = nums[0]; //dp[i-2] max amount of houses that can be robbed upto 2 houses before current house
        int prev1 =  Math.max(nums[0], nums[1]); // dp[i-1] max amount that can be robbed upto house immediately before current house
        int n =nums.length;
        for (int i=2; i<n; i++){ // starting from 3 rd house
            int current = Math.max(prev1, nums[i]+ prev2); // max of choose or no choose
            prev2 = prev1; // update prev2 to prev1
            prev1 = current; // update prev1 to current

        }
        return prev1; // return max money robbed upto last house
    }
    public static void main (String [] args){
        RobHouses rob = new RobHouses();
        int [] nums = {2,7,9,3,1};
        int maxAmount = rob.robHouse(nums);

        System.out.println(maxAmount);

    }
}
