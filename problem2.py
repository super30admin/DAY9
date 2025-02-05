# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        N = len(matrix)
        memo = {}
        def recurse(floor, ix):
            if floor in memo and ix in memo[floor]:
                return memo[floor][ix]

            if ix < 0 or ix == N:
                return float('inf')
            if floor == N:
                return 0
            
            cur_min = float('inf')
            for di in [-1,0,1]:
                cur_min = min(cur_min, recurse(floor+1, ix + di) + matrix[floor][ix])
            
            if floor in memo:
                memo[floor][ix] = cur_min
            else:
                memo[floor] = {}
                memo[floor][ix] = cur_min
            
            return memo[floor][ix]
        
        global_min = float('inf')
        for i in range(N):
            global_min = min(global_min, recurse(0, i))
        
        return global_min