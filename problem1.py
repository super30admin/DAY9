# Time Complexity : O(n + max(nums))
# Space Complexity : O(n + max(nums))
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        vals = [0] * (max(nums) + 1)

        for num in nums:
            vals[num] += 1
        
        for ix, val in enumerate(vals):
            vals[ix] *= ix
        
        print(vals)
        memo = {}
        def recurse(ix):
            if ix in memo:
                return memo[ix]
            if ix >= len(vals):
                return 0
            
            choose = recurse(ix+2) + vals[ix]
            _choose = recurse(ix+1)

            memo[ix] = max(choose, _choose)
            return memo[ix]
        
        return recurse(0)