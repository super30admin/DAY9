# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def deleteAndEarn(self, nums):
        if not nums:
            return 0
        
        max_val = max(nums)
        dp = [0] * (max_val + 1)
        
        for num in nums:
            dp[num] += num
        
        skip, take = 0, 0
        
        for i in range(len(dp)):
            temp_skip = skip
            skip = max(skip, take)
            take = temp_skip + dp[i]
        
        return max(skip, take)

# Example 1
solution = Solution()
nums = [3, 4, 2]
print(solution.deleteAndEarn(nums))  # Output: 6

# Example 2
nums = [2,2,3,3,3,4]
print(solution.deleteAndEarn(nums))  # Output: 9

# Example 3
nums = [12]
print(solution.deleteAndEarn(nums))  # Output: 12