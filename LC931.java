// TC: O(n), where n is the length of the input matrix.
// SC: O(1)

public class LC931 {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix.length;j++){
                int min = Integer.MAX_VALUE;
                // Left
                if(j>0) min = Math.min(min, matrix[i+1][j-1]);
                // Below
                min = Math.min(min, matrix[i+1][j]);
                // Right
                if(j<matrix.length-1) min = Math.min(min, matrix[i+1][j+1]);

                matrix[i][j] += min;
            }
        }
        int minAns = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            minAns = Math.min(minAns, matrix[0][i]);
        }
        return minAns;
    }
}