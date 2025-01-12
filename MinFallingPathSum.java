//TC: O(n^2)
//SC: O(1)
//approach: dynamic programming

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        for(int i=n-2;i>=0;i--){
            for(int j=0; j<n; j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i+1][0], matrix[i+1][1]);
                }else if(j == n-1){
                    matrix[i][j] += Math.min(matrix[i+1][n-1], matrix[i+1][n-2]);
                }else{
                    matrix[i][j] += getMin(new int[]{matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1]});
                }
            }
        }
        return getMin(matrix[0]);
    }

    public int getMin(int[] nums){
        int min = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]<min) min = nums[i];
        }
        return min;
    }
}
