class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp= new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j>0 && j!=n-1){
                    int left=matrix[i][j]+dp[i+1][j-1];
                    dp[i][j]=Math.min(left,Math.min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j+1]));
                }
                else if(j==0){
                    dp[i][j]=Math.min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j+1]);
                }
                else{
                    dp[i][j]=(Math.min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j-1]));

                }
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
