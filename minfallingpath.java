class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){

                if(j==0) {
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==matrix[0].length-1) {
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j]+=Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
                }
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            matrix[0][0]=Math.min(matrix[0][0],matrix[0][j]);            
        }
        return matrix[0][0];
    }

}
