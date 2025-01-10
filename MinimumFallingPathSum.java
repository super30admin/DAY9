// Time Complexity: O(m x n) as the array row vs length is traversed
// Space Complexity: O(1) as no extra data structure has been used

// This is the bottom up dynamic programming approach
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] { { 0 } })); // 0
        System.out.println(minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } })); // 13
        System.out.println(minFallingPathSum(new int[][] { { -19, 57 }, { -40, -5 } })); // -59
    }

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int row = rowLength - 2; row >= 0; row--) {
            for (int col = 0; col < colLength; col++) {
                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row + 1][col], matrix[row + 1][col + 1]);
                } else if (col == colLength - 1) {
                    matrix[row][col] += Math.min(matrix[row + 1][col], matrix[row + 1][col - 1]);
                } else {
                    matrix[row][col] += Math.min(matrix[row + 1][col - 1],
                            Math.min(matrix[row + 1][col], matrix[row + 1][col + 1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < colLength; col++) {
            min = Math.min(min, matrix[0][col]);
        }
        return min;
    }

}