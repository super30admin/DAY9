public class MinimumFailingPathSum {
    // Time Complexity :
    // Space Complexity :
    // Did this code successfully run on Leetcode : gave time limit exceeded
    // Any problem you faced while coding this : no
    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++) {
            int case1 = helper(0, i, matrix, 0);
            minSum = Math.min(case1, minSum);
        }

        return minSum;
    }

    private int helper(int row, int col, int[][] matrix, int sum) {

        if( col >= matrix[0].length || col < 0){
            return Integer.MAX_VALUE;
        }

        if(row == matrix.length - 1) {
            return sum + matrix[row][col];
        }

        //logic
        int case1 = helper(row + 1, col - 1, matrix, sum + matrix[row][col]);// integer.maxvalue
        int case2 = helper(row + 1, col, matrix, sum + matrix[row][col]);//2+6
        int case3 = helper(row + 1, col + 1, matrix, sum + matrix[row][col]);;

        return Math.min(case1,Math.min(case2,case3));
    }

    // Time Complexity :n ^2
    // Space Complexity :-do-
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no
    public int minFallingPathSumUsingBottomUpDp(int[][] matrix) {
        int dp[][] = new int[matrix.length + 1][matrix.length + 1];
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    dp[row][col] =
                            Math.min(dp[row + 1][col], dp[row + 1][col - 1]) + matrix[row][col];
                } else {
                    dp[row][col] = Math.min(dp[row + 1][col],
                            Math.min(dp[row + 1][col + 1], dp[row + 1][col - 1])) + matrix[row][col];
                }
            }
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, dp[0][startCol]);
        }
        return minFallingSum;
    }

    // DP bottom up solution , space optimized
    // Did this code successfully run on Leetcode : yes
    public int minFallingPathSumSpaceOptimized(int[][] matrix) {
        int dp[] = new int[matrix[0].length];

        for(int index = 0; index < matrix[0].length; index++) {
            dp[index] = matrix[matrix.length - 1][index];
        }

        int tempCurrMin = 0;
        int tempLeftMIn = 0;
        int tempLeftDoubleMin = 0;
        for(int row = matrix.length - 2; row >= 0; row --) {
            for(int col = 0; col <= matrix[0].length - 1; col++) {
                tempLeftDoubleMin = tempLeftMIn;
                tempLeftMIn = tempCurrMin;

                int leftPath = col - 1 < 0 ? Integer.MAX_VALUE: dp[col - 1];
                int centrePath = dp[col];
                int rightPath = col + 1 == matrix[0].length ? Integer.MAX_VALUE : dp[col + 1];

                tempCurrMin = matrix[row][col] + Math.min(leftPath, Math.min(centrePath, rightPath));

                if(col - 2 >= 0){
                    dp[col - 2] = tempLeftDoubleMin;

                }
            }
            dp[dp.length - 1] = tempCurrMin;
            dp[dp.length - 2] = tempLeftMIn;
        }

        int pathMin = Integer.MAX_VALUE;

        for(int col = 0; col < matrix[0].length; col++) {
            pathMin = Math.min(pathMin, dp[col]);
        }

        return pathMin;
    }

}
