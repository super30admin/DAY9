/***
 Approach -
 1. For calculating min value at any (row,col), we need to calculate the min((row+1, col-1), (row+1, col) , (row+1, col+1))
 and add it to the value at (row,col)
 2. We will start with row= (n-2) and calculate the min value at every col for current row
 3. At the end, we need to return the min value from the 1st row
 4. We will re-use the same matrix to store the result.
 TC - O(n^2), SC - O(1)
 */
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for(int row = n-2; row >= 0; row--) {
            for(int col = 0; col < n; col++) {
                if(col == 0) // can't take col-1 index
                    matrix[row][col] = matrix[row][col] + Math.min(matrix[row+1][col], matrix[row+1][col+1]);
                else if(col == n-1) // can't take col+1 index
                    matrix[row][col] = matrix[row][col] + Math.min(matrix[row+1][col-1], matrix[row+1][col]);
                else
                    matrix[row][col] = matrix[row][col] + Math.min(matrix[row+1][col+1],
                            Math.min(matrix[row+1][col-1], matrix[row+1][col]));
            }
        }

        for(int col =0; col < n ; col++) {
            min = Math.min(min, matrix[0][col]);
        }

        return min;

    }
}