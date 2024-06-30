"""
## Problem1: (https://leetcode.com/problems/delete-and-earn/)
"""

# Approach 1 :  taking an exhaustive approach 
# TC: 2 ^ N where n is the length of array of nums
# SC: 2 ^ N

class Solution:
    def helperFunction(self, nums, idx):
        #base function
        if (idx >= len(nums)):
            return 0

        #logic
        #case 1:  on pick the number
        case_1 = nums[idx] + self.helperFunction(nums, idx + 2)

        #case 2: do not pick the number
        case_2 = 0 + self.helperFunction(nums, idx + 1)

        return max(case_1, case_2)
        
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums: return 0
        
        max_num = float('-inf')
        
        for n in nums:
            max_num = max(n, max_num)
            
        new_nums = [0 for _ in range(max_num + 1)]
        
        for n in nums:
            new_nums[n] += n
            
       
        return self.helperFunction(new_nums, 0)


# Approach 2: DP matrix
# TC: O(n)
# SC: O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums: return 0
        
        max_num = max(nums)
        
        dp = [0 for _ in range(max_num + 1)]
        new_nums = [0 for _ in range(max_num + 1)]
        
        for n in nums:
            new_nums[n] += n
            
        dp[0] = 0
        dp[1] = new_nums[1]
        
        for i in range(2,len(dp)):
            dp[i] = max(dp[i-1], dp[i-2] + new_nums[i])
            
            
        return dp[len(dp) - 1]
            
            
       
        
        
         