// Time Complexity :O(n**2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// 1. Start from 2nd last row and add the minimum element that satisfies the condition from the next
// row to the current row
// 2. keep on doing this until 1st row is done too.
// 3. then return the minimum element from the first row



class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int n = matrix.length;
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j==0) matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                else if(j==n-1) matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                else matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j+1], Math.min(matrix[i+1][j], matrix[i+1][j-1]));
            }
        }
        int minimum=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(minimum > matrix[0][i]) minimum = matrix[0][i];
        }
        return minimum;
    }
}

//class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         for(int i=n-2; i>=0; i--){
//             for(int j=0; j<n; j++){
//                 boolean left = false;
//                 boolean right = false;
//                 int min1=0, min2=0;
//                 if(j-1>=0){
//                     min1 = matrix[i][j] + Math.min(matrix[i+1][j-1], matrix[i+1][j]);
//                     left = true;    
//                 }
//                 if(j+1<n){
//                     min2 = matrix[i][j] + Math.min(matrix[i+1][j+1], matrix[i+1][j]);
//                     right = true;
//                     if(!left) matrix[i][j] = min2;
//                 }
//                 if(left && right) matrix[i][j] = Math.min(min1, min2);
//                 if(left && !right) matrix[i][j] = min1;
//             }
//         }
//         int min = Integer.MAX_VALUE;
//         for(int i =0; i<n; i++){
//             if(matrix[0][i] < min) min = matrix[0][i];
//         }
//         return min;
//     }
// }

