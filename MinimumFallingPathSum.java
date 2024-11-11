// Time Complexity :O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;

        int[][] dp= new int[n][n];

        for(int i=0; i<n; i++){
            dp[0][i]=matrix[0][i];
        }

        for(int i=1; i<m; i++ ){
            for(int j=0; j<n; j++){
                if(j==0){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if(j==n-1){
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], dp[i-1][j-1]);
                }else{
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
                }
            }
        }
        int ans=Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }

    public static void main(String args[]) {
        MinimumFallingPathSum minimum = new MinimumFallingPathSum();
        int[][] nums={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Output "+ minimum.minFallingPathSum(nums));

    }
}
