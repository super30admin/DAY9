// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Applied bottom up approach of dp to solve the problem. Similar to painting house;

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
    let n = matrix.length;
    let min = 999999;
    for (let i = n - 2; i >= 0; i--) {
        for (let j = 0; j < n; j++) {
            if (j != 0 && j != n - 1) {
                matrix[i][j] = Math.min((matrix[i][j] + matrix[i + 1][j - 1]),
                    (matrix[i][j] + matrix[i + 1][j]), (matrix[i][j] + matrix[i + 1][j + 1]));
            }
            else if (j == 0) {
                matrix[i][j] = Math.min((matrix[i][j] + matrix[i + 1][j]), (matrix[i][j] + matrix[i + 1][j + 1]));
            }
            else if (j == n - 1)
                matrix[i][j] = Math.min((matrix[i][j] + matrix[i + 1][j - 1]),
                    (matrix[i][j] + matrix[i + 1][j]));
        }
    }
    for (let j = 0; j < n; j++) {
        min = Math.min(min, matrix[0][j]);
    }
    return min;

};