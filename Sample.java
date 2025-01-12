/**************************PROBLEM-1********************/

// Time Complexity : O(max(n,m)) N=no of rows in matrix, m=max element in the matrix
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null|| nums.length==0){
            return 0;
        }
        int n=nums.length,max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int[] dp=new int[max+1];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]+=nums[i];
        }

        int skip=0,take=0;
        for(int i=1;i<dp.length;i++){
            int tempSkip=skip;
            skip=Math.max(skip,take);
            take=tempSkip+dp[i];
        }
        return Math.max(skip,take);
    }
}

/**************************PROBLEM-2********************/

// Time Complexity : O(N*n) N=no of rows in matrix, n=no of columns in matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Track the minimum from bottom up and return the min of 1st row
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null ||matrix.length==0){
            return 0;
        }
        int n=matrix.length-1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<matrix[i].length;j++){
                if(j==0){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][1],matrix[i+1][0]);
                }else if(j==n){
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][n],matrix[i+1][n-1]);
                }else{
                    matrix[i][j]=matrix[i][j]+Math.min(matrix[i+1][j+1],
                            Math.min(matrix[i+1][j],matrix[i+1][j-1]));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<=n;j++){
            min=Math.min(matrix[0][j],min);
        }
        return min;
    }
}

