// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// repeated patterns liek min of children is identified

class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int n = matrix.length;
        for(int i=n-2; i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                } else if(j==n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }

    public static void main(String[] args) {
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        System.out.println((obj.minFallingPathSum(matrix)));
    }
}