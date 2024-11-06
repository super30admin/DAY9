//Time Complexity : O(n^2) where n is number of elements
// Space Complexity : O(1) Constant space
// Ran on LeetCode : yes
//Any Problems : No

class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Start from the second-last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {

                // Find the minimum of the three possible positions in the row below
                int down = matrix[row + 1][col];
                int downLeft = col > 0 ? matrix[row + 1][col - 1] : Integer.MAX_VALUE;
                int downRight = col < n - 1 ? matrix[row + 1][col + 1] : Integer.MAX_VALUE;

                // Update the current cell with the minimum path sum
                matrix[row][col] += Math.min(down, Math.min(downLeft, downRight));
            }
        }

        // The minimum path sum starting from the first row
        int minPathSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, matrix[0][col]);
        }

        return minPathSum;
    }
    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();

        // Example matrix
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int result = solution.minFallingPathSum(matrix);
        System.out.println("Minimum Falling Path Sum: " + result);
    }
}