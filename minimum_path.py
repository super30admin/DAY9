#t.c = O(n^2)
#s.c = O(n)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        n = len(matrix)

        for row in range(n - 2, -1, -1):
            for col in range(n):
                left = matrix[row + 1][col - 1] if col - 1 >= 0 else float('inf')
                down = matrix[row + 1][col]
                right = matrix[row + 1][col + 1] if col + 1 < n else float('inf')
                

                matrix[row][col] += min(left, down, right)

        return min(matrix[0])




        