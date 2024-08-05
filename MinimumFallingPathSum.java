//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0;i<n;i++){
            dp[m-1][i] = matrix[m-1][i];
        }
        for(int i = m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
                else if(j==n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }
                else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i+1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n;i++){
            if(min>dp[0][i]){
                min = dp[0][i];
            }
        }

        return min;
    }

    public static void main(String[] args){
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}};
        int result = minFallingPathSum(matrix);
        System.out.println(result);
    }
}
