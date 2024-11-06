public class Problem1 {

    //Time Complexity : O(N+k).
    //Space complexity O(N+k). : N is itereating over nums array and K is populating the sumMap
    // k is dependent on the max value of the array;
    public int deleteAndEarn(int[] nums) {
        //find max of the number in the array
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max,num);
        }
        //store the sum at number index
        int [] sumMap = new int[max+1];

        for(int num : nums){
            sumMap[num] = sumMap[num] + num;
        }

        int[] dp = new int [max+1];

        dp[0] = 0;
        dp[1] = sumMap[1];

        for(int i=2;i<sumMap.length;i++){
            //no choose
            int case1 =  dp[i-1];

            //chose
            int case2 = sumMap[i] + dp[i-2];

            dp[i] = Math.max(case1,case2);


        }

        return dp[dp.length-1];


    }
}
