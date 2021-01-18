// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0) return 0;
        for(int i = A.length - 2; i >= 0; i --){
            for(int j = 0; j < A[i].length; j++){
                if(j == 0) A[i][j] = A[i][j] + Math.min(A[i+1][j],A[i+1][j+1]);
                else if(j == A[i].length - 1) A[i][j]  = A[i][j] + Math.min(A[i+1][j], A[i+1][j-1]);
                else A[i][j] = A[i][j] + Math.min(A[i+1][j], Math.min(A[i+1][j-1],A[i+1][j+1]));
            }
        }
        int min = Integer.MAX_VALUE;

        for(int k = 0; k < A[0].length; k++){
            if(A[0][k] < min) min = A[0][k];
        }
        return min;
    }
} 