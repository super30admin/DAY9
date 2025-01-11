// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
public class Problem1 {

    //same as paint house but here we need to take care of col also
    public int minFallingPathSum(int[][] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;

        for(int i = n-2;i>=0;i--){
            for(int j =0 ; j<n;j++){
                //for 0 index row
                if(j==0){
                    nums[i][j] = nums[i][j] + Math.min(nums[i+1][j],nums[i+1][j+1]);
                }
                else if(j==n-1){
                    //for last index row
                    nums[i][j] = nums[i][j] + Math.min(nums[i+1][j-1],nums[i+1][j]);
                }
                else{
                    //for any  row in between
                    nums[i][j] = nums[i][j] + Math.min(nums[i+1][j-1],Math.min(nums[i+1][j],nums[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            min = Math.min(nums[0][i],min);
        }

        return min;
    }
}
