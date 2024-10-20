class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
      if matrix == None or len(matrix) == 0:
        return 0
      cache = {}
      return min(self.recurse(matrix, cache, 0,  col) for col in range(len(matrix[0])))

    def recurse(self, matrix: List[List[int]], cache:dict, rows:int, cols:int):
      # Base 
      if rows == len(matrix):
          return 0
      if cols < 0 or cols >= len(matrix[0]):
        return float("inf")
      if (rows, cols) in cache:
        return cache[(rows, cols)]
      # Logic
      min_sum = float("inf")
      for d in [-1, 0, 1]:  # Check left, down, and right
            new_cols = cols + d
            min_sum = min(min_sum, matrix[rows][cols] + self.recurse(matrix, cache, rows + 1, new_cols))
      cache[(rows, cols)] = min_sum
      return min_sum
 