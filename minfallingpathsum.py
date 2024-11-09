"Time Complexity is O(N^2)"
"Space Complexity is O(1)"

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n == 1:
            return min(matrix[0])
        
        # Iterate from the second row to the last row
        for i in range(1, n):
            for j in range(n):
                # Check the three possible cells from the row above
                top_left = matrix[i-1][j-1] if j > 0 else float('inf')
                top = matrix[i-1][j]
                top_right = matrix[i-1][j+1] if j < n - 1 else float('inf')
                
                # Update the current cell with the minimum path sum to reach this cell
                matrix[i][j] += min(top_left, top, top_right)
        
        # The answer is the minimum value in the last row
        return min(matrix[-1])
            