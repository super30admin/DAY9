// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally 
// left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// First Approach:
// Exhaustive Approach 0-1 recursion
//In this I am not getting how the recursion is working and I am getting a wrong answer. Could you please explain me?
// Time Complexity : Exponential as every call is calling 2 different calls further.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //base Condition
        if(matrix==null || matrix.length==0){
            return 0;
        }
        //Claculating length and iterating the loop on every columns and then at the end returning the minimum
        int n=matrix.length;
        int min=Integer.MAX_VALUE;;
        for(int i=0;i<n;i++){
            min=Math.min(min,recurse(matrix,0,i,0));
        }
        return min;
    }

    private int recurse(int[][] matrix,int row,int col,int minSum){

        if(row==matrix.length-1){
            return minSum;
        }
        minSum=minSum+matrix[row][col];
        //Logic
        if(col==0){
            return(Math.min(recurse(matrix,row+1,col,minSum+matrix[row][col]),recurse(matrix,row+1,col+1,minSum)));
        }
        else if(col==matrix.length-1){
            return(Math.min(recurse(matrix,row+1,col,minSum+matrix[row][col]),recurse(matrix,row+1,col-1,minSum)));
        }
        else{
            int a=recurse(matrix,row+1,col-1,minSum);
            int b=recurse(matrix,row+1,col,minSum);
            int c=recurse(matrix,row+1,col+1,minSum);
            return(Math.min(a,Math.min(b,c)));
        }
    }
}


//Approach 2:
// In this we will use a DP approach
//Time Complexity : O(n2)
//Space Complexity : O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //Base condition  check
        if(matrix==null || matrix.length==0){
            return 0;
        }
        //Here we are iterating from n-2 to 0 i.e bottom up.
        //also we will iterate through each column as there are no fix no of columns
        int n=matrix.length;
        int min=Integer.MAX_VALUE;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if(j==n-1){
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j]+ Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
        //At the row 0 and every column we will have the sum of that column iteration 
        // We will return the minimum from them
        for(int i=0;i<n;i++){
            min=Math.min(min,matrix[0][i]);
        }

        return min;
    }
}

// In the above code we are modifying the original array
// If Interviewer asks us to not modify it we can use other 1-d array to store the computations

