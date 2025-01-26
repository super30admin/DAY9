
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = matrix
        rows = len(m)
        cols = len(m[0])
        memo = {}
        #print(memo)
        pathsum = [float('inf')] * cols
        def dp(r, c):
            if (r,c) in memo:
                return memo[(r,c)]
            if r >= rows:
                return 0
            if c == 0:
                memo[(r,c)] = min(m[r][c] + dp(r+1, c), m[r][c] + dp(r+1, c+1))
            elif c == cols-1:
                memo[(r,c)] = min(m[r][c] + dp(r+1, c-1), m[r][c] + dp(r+1, c))
            else:
                memo[(r,c)] = min(m[r][c] + dp(r+1, c-1), m[r][c] + dp(r+1, c), m[r][c] + dp(r+1, c+1))
    
            return memo[(r,c)]
        
        # pathsum = [ minimum sum when we choose [0,0], [0,1], [0,2],...and so on ]
        for i in range(cols):
            pathsum[i] = dp(0,i)
        
        print(pathsum)
        # return the least sum
        return min(pathsum)
## TC = O(n*n) SC = O(x + y) - x is pathsum and y is memo (rows*cols)