/*
Let N be the length of matrix.

Time Complexity: O(N⋅3^N)
    The solution takes the form of a 3-ary recursion tree where there are 3 possibilities for every node in the tree.
    The time complexity can be derived as follows,
    The maximum depth of the recursion tree is equal to the number of rows in the matrix i.e N.
    Each level (level) of the recursion tree will contain approximately 3
    level nodes. For example, at level 0 there are 3 nodes, for level 1, 3 nodes, and so on. Thus, the maximum number of
    nodes at level N would be approximately 3N.

    The time complexity is exponential, hence this approach is exhaustive and results in Time Limit Exceeded (TLE).

Space Complexity: O(N) This space will be used to store the recursion stack. As the maximum depth of the tree is N,
    we will not have more than N recursive calls on the call stack at any time.
 */

class MinimumFallingPathExhaustive {
    public int minFallingPathSum(int[][] matrix) {

        int minSum = Integer.MAX_VALUE;
        // Start from each column in the first row
        for (int startCol = 0; startCol < matrix[0].length; startCol++) {
            minSum = Math.min(minSum, helper(matrix, 0, startCol, 0));
        }

        return minSum;
    }

    private int helper(int[][] matrix, int i, int column, int sum)
    {
        // Add the current cell's value to the cumulative sum
        sum += matrix[i][column];

        // Base case: If we've reached the last row, return the sum
        if (i == matrix.length - 1) {
            return sum;
        }

        //logic
        int min = Integer.MAX_VALUE;

        //Directly below
        min = Math.min(min, helper(matrix, i+1, column, sum));

        // Diagonally left (if within bounds)
        if (column > 0) {
            min = Math.min(min, helper(matrix, i + 1, column - 1, sum));
        }

        // Diagonally right (if within bounds)
        if (column < matrix[0].length - 1) {
            min = Math.min(min, helper(matrix, i + 1, column + 1, sum));
        }

        return min;
    }
}