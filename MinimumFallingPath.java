public class MinimumFallingPath {
    //time complexity: O(n^2)
    //space complexity: O(1)
    //thought process:
    //1. start from the last row and move up
    //2. for each row, update the cost of falling path with the minimum cost of falling path of the next row
    //3. return the minimum cost of falling path of the first row
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
 
        for (int i = n-2;i>=0;i--){
         for (int j = 0;j< matrix[0].length;j++){
             if (j == 0){
                 matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
             } else if (j == matrix[0].length-1){
                 matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
             } else {
                 matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],Math.min(matrix[i+1][j-1],matrix[i+1][j+1]));
 
             }
         }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < matrix[0].length;i++){
         min = Math.min (min, matrix[0][i]);
        }
        return min; 
     }
}
