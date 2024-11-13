// Time Complexity: O(n^2), where n is the size of the matrix. We iterate through each element of the matrix, updating our dp array.
// Space Complexity: O(n), where n is the number of columns. We use an additional dp array of size n to store the minimum path sums.
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Initially, I faced difficulties in correctly handling the boundary conditions for the left and right diagonal paths. Ensuring we don’t go out of bounds required special checks.

// Your code here along with comments explaining your approach

/*
Approach:
1. We use a bottom-up dynamic programming strategy, starting from the last row and moving upwards to the first row.
2. We maintain a dp array that stores the minimum falling path sums from each column of the current row to the last row.
3. For each element in the current row, we calculate the minimum sum from the three possible falling paths:
   - Directly below
   - Diagonally left (with boundary checks)
   - Diagonally right (with boundary checks)
4. We update a temporary array to hold the new minimum sums for the current row, ensuring we do not overwrite values in the dp array prematurely.
5. The result is the minimum value in the dp array after processing all rows.
*/


public class problem2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Iterate from the second last row to the first row, updating each element
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                // Compute the possible paths to take from the next row
                int down = matrix[row + 1][col]; // directly below
                int downLeft = (col > 0) ? matrix[row + 1][col - 1] : Integer.MAX_VALUE; // diagonally left
                int downRight = (col < n - 1) ? matrix[row + 1][col + 1] : Integer.MAX_VALUE; // diagonally right

                // Update the current element with the minimum sum of the falling path
                matrix[row][col] += Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // Find the minimum value in the first row, which represents the minimum falling path sum
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, matrix[0][col]);
        }

        return minSum;
    }
}
