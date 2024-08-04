## Bottom Up approach
## start from second last row, updating minimum value at each matrix index as we iterate through each array
## Time Complexity  O(n^2)
## Space Complexity O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        N = len(matrix)

        for r in range(1, N):
            for c in range(N):
                left = matrix[r-1][c-1] if c > 0 else float("inf")
                mid = matrix[r-1][c]
                right = matrix[r-1][c+1] if (c < N -1) else float("inf")
                matrix[r][c] = matrix[r][c] + min(left, mid , right)
        
        return min(matrix[-1])


        
