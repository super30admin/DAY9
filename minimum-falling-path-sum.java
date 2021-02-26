// Time Complexity :
It is O(r*c) where r= no.of rows and c= no.of columns
// Space Complexity :
O(1)
// Did this code successfully run on Leetcode :
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        //no.of rows
        int r = matrix.length;
        //no.of columns
        int c = matrix[0].length;
        
        //Traverse through the matrix from row 2
        
        for(int i =1 ; i < r ; i++){
            for(int j = 0; j < c ; j++){
                //edge case: when column is the first column
                if( j == 0){
                    matrix [i][j] += Math.min(matrix[i-1][j], matrix [i-1][j+1]);
                }
                //when column is the last column
            else if(j == c-1){
                matrix [i][j] += Math.min(matrix[i-1][j], matrix [i-1][j-1]); 
            }
            else{
                matrix [i][j] += Math.min(Math.min(matrix[i-1][j], matrix [i-1][j-1]),
                                        matrix [i-1][j+1]);
            }
            }
        }
        
    // Traverse through last row and get the min of all the sum's calculated so far
        int minimumSoFar= Integer.MAX_VALUE;
    for(int k=0;k<c;k++){
        minimumSoFar = Math.min(minimumSoFar, matrix[r-1][k]);   
    }
        return minimumSoFar;
    }
}