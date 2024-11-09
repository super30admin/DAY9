/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
  for (let row = 1; row < matrix.length; row++) {
    for (let col = 0; col < matrix[row].length; col++) {
      let left = Number.MAX_SAFE_INTEGER;
      let mid = matrix[row - 1][col];
      let right = Number.MAX_SAFE_INTEGER;
      if (col > 0) {
        left = matrix[row - 1][col - 1];
      }
      if (col < (matrix[row].length - 1)) {
        right = matrix[row - 1][col + 1];
      }
      matrix[row][col] = matrix[row][col] + Math.min(left, right, mid);
    }
  }
  return Math.min(...matrix[matrix.length - 1]);
};

var minFallingPathSumWithRecursion = function (matrix) {
  let min = Number.MAX_SAFE_INTEGER;
  for (let index = 0; index < matrix[0].length; index++) {
    min = Math.min(min, helper(matrix, 0, index, 0));
  }
  return min;
};

var helper = function (matrix, row, column) {
  if (row == matrix.length) {
    return 0;
  }
  if (column < 0 || column == matrix.length) {
    return Number.MAX_SAFE_INTEGER;
  }

  // Explore All Paths
  let currentValue = matrix[row][column];
  let leftMin = helper(matrix, row + 1, column - 1);
  let centerMin = helper(matrix, row + 1, column);
  let rightMin = helper(matrix, row + 1, column + 1);

  // return
  return currentValue + Math.min(leftMin, centerMin, rightMin);
};

test("Scenario #2: Happy Path", () => {
  let nums = [
    [2, 1, 3],
    [6, 5, 4],
    [7, 8, 9],
  ];
  expect(minFallingPathSum(nums)).toStrictEqual(13);
});
