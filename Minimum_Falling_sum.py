class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
      if matrix == None or len(matrix) == 0:
        return 0
            # 2 1 3     2  1   3.    -19 57.  -19 57 
            # 6 5 4     7  6.  5     -40 -5.  -59 -23
            # 7 8 9     13 13  14

      dp = [[0 for i in range(len(matrix))]for i in range(len(matrix[0]))]
      for i in range(len(matrix)):
        dp[0][i] = matrix[0][i] 

      for i in range(1,len(dp)):
        for j in range(len(dp[0])):
          if j == 0:
            dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
          elif j == len(dp)-1:
            dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j-1])
          else:
            dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1], dp[i-1][j-1])
      return min(dp[-1])

     
      print(dp)
    
    
    #   cache = {}
    #   return min(self.recurse(matrix, cache, 0,  col) for col in range(len(matrix[0])))

    # # def recurse(self, matrix: List[List[int]], cache:dict, rows:int, cols:int):
    # #   # Base 
    # #   if rows == len(matrix):
    # #       return 0
    # #   if cols < 0 or cols >= len(matrix[0]):
    # #     return float("inf")
    # #   if (rows, cols) in cache:
    # #     return cache[(rows, cols)]
    # #   # Logic
    # #   min_sum = float("inf")
    # #   for d in [-1, 0, 1]:  # Check left, down, and right
    # #         new_cols = cols + d
    # #         min_sum = min(min_sum, matrix[rows][cols] + self.recurse(matrix, cache, rows + 1, new_cols))
    # #   cache[(rows, cols)] = min_sum
    # #   return min_sum
