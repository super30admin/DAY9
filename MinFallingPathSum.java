// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, re aligning my mental model to fit the problem. The way the problem is stated made me go think from top. But took a while to understand that i have to do bottom up

/*
 * Why DP? Why bottom up? -> DP to solve in O(1) space-> each row solved before will act as a cache to determine the min in the next row.
 * 
 * Bottom up because we have root values of row n-1 will determine the min in row n-2 and so on until row 0
 * 
 * We want to find the min failing path.. the sub problem is for a given i-2 -> whats the min? 
 * Also each cell has only 3 possible paths falling -> left, center, right (got confused until i did it on paper)
 * 
 * Having the last row as seed value-> calculate the min at i-2 row and each column.. as we go to the row 0 we will get the min sum for each taken path.
 * 
 */

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                int left = 999999;
                if (j - 1 >= 0) {
                    left = matrix[i + 1][j - 1];
                }

                int right = 999999;

                if (j + 1 < c) {
                    right = matrix[i + 1][j + 1];
                }

                int center = matrix[i + 1][j];

                int localMin = Math.min(left, Math.min(right, center));
                matrix[i][j] += localMin;
            }
        }
        int globalMin = 999999;

        for (int j = 0; j < c; j++) {
            globalMin = Math.min(globalMin, matrix[0][j]);
        }

        return globalMin;
    }
}
