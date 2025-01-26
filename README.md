# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = Counter(nums)
        nums = list(sorted(set(nums))) # unique nums only points can be calculated using freq
        print(nums, freq)
        size = len(nums)-1 # giving last place to see points earned at every place
        memo = {}
        def dp(i):
            if i < 0: # empty array
                return 0
            if i in memo:
                return memo[i]
            earned_points = nums[i] * freq[nums[i]]
            # lets decide 
            # in both take these points or not
            # if we use it and if previous num + 1 = curr, we need to jump 2 places 
            if i > 0 and nums[i-1] == nums[i]-1:
                result = max(earned_points + dp(i-2), dp(i-1))
            else:
                result = max(earned_points + dp(i-1), dp(i-1))
            memo[i] = result
            return result
        return dp(size)
# time and space complexity
# n = max(nums)
# time: O(n)
# space: O(n)
            
            

## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

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