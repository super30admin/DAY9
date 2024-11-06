public class Problem2 {

    //TC:O(M∗N)
    //SC : O(M∗N)
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n];

        for(int r=1 ;r<=m;r++){
            for(int c =0;c<n;c++ ){
                //this is for the current (r,c) we have to get the minimum from previous

                //r-1,c
                int minVal = Integer.MAX_VALUE;
                if((r-1)>=0 && c>=0){
                    minVal = Math.min(minVal,dp[r-1][c]);
                }

                //r-1,c-1
                if((r-1)>=0 && (c-1)>=0){
                    minVal = Math.min(minVal,dp[r-1][c-1]);
                }

                //r-1,c+1
                if((r-1)>=0 && c+1<n){
                    minVal = Math.min(minVal,dp[r-1][c+1]);
                }

                dp[r][c] = minVal + matrix[r-1][c];
            }

        }

        int result = Integer.MAX_VALUE;
        //minimum in the last row is the solution
        for(int i = 0 ;i<n;i++){
            result = Math.min(result,dp[m][i]);
        }

        return result;
    }
}
