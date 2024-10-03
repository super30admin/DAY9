class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        # len of first row because it is a square matrix
        n = len(matrix[0])
        # start from second last row and go through each column
        for row in range(n - 2, -1, -1):
            for col in range(n):
                best_below = matrix[row + 1][col]
                # if not first column then check right position also
                if col > 0:
                    best_below = min(best_below, matrix[row + 1][col - 1])
                # if not last column then check left position also
                if col < n - 1:
                    best_below = min(best_below, matrix[row + 1][col + 1])
                matrix[row][col] += best_below
        # return minimum from the first row
        return min(matrix[0])


# time complexity is O(n^2)
# space complexity is O(1)
