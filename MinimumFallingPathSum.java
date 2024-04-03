// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
// Space Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix, due to the pathSum array.
// Approach: This solution utilizes dynamic programming. We initialize a 2D array pathSum to store the minimum falling path sum from each cell. We iterate through the matrix, calculating the minimum falling path sum for each cell based on the minimum of the adjacent cells from the previous row. Finally, we return the minimum falling path sum from the last row of pathSum.
// LeetCode Link: https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = rows;
        int pathSum[][] = new int[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(r == 0){
                    pathSum[0][c] = matrix[r][c];
                }else{
                    pathSum[r][c] = matrix[r][c] + Math.min(pathSum[r-1][c], Math.min(((c-1 > -1) ? pathSum[r-1][c-1] : Integer.MAX_VALUE), (c+1 < cols) ? pathSum[r-1][c+1] : Integer.MAX_VALUE));
                }
            }
        }
        int minPathSum = Integer.MAX_VALUE;
        for(int pSum : pathSum[rows-1])minPathSum = Math.min(minPathSum, pSum);
        return minPathSum;
        
    }
}




