//Time - O(m*n)
//Space - O(1)
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] nums) {
        if(nums==null) return 0;

        int res = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums[0].length; j++){

                int min = Integer.MAX_VALUE;
                if(j==0){
                    min = Math.min(nums[i-1][j], nums[i-1][j+1]);
                } else if(j==nums[0].length-1) {
                    min = Math.min(nums[i-1][j-1], nums[i-1][j]);
                } else {
                    min = Math.min(Math.min(nums[i-1][j-1], nums[i-1][j]),nums[i-1][j+1]);
                }

                nums[i][j] = nums[i][j] + min;
            }
        }

        for(int i=0; i<nums[0].length; i++){
            res = Math.min(res, nums[nums.length-1][i]);
        }

        return res;
    }
}