//Time complexity: O(n^2)
//Space complexity: O(1)
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int n = matrix.length;

        //start from the second last row and keep adding the minimum of the next row
        for(int i = n-2;i>=0;i--){
            for(int j=0;j<n;j++){

                //if the element is in the first column, then add the minimum of the next row's first column and second column
                if(j==0){
                    matrix[i][j] =  matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }

                //if the element is in the last column, then add the minimum of the next row's last column and second last column
                else if(j== n -1){
                    matrix[i][j] =  matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }

                //if the element is in the middle, then add the minimum of the next row's middle column, left column and right column
                else{
                    matrix[i][j] =  matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j+1],
                    matrix[i+1][j-1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        //find the minimum of the first row
        for(int j=0;j<n;j++){
            min = Math.min(min, matrix[0][j]);
        }
        return min;
    }


}

