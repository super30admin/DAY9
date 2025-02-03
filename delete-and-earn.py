'''
Time complexity: O(max(n,max(nums))) where n is the length of nums
Space complexity: O(max(nums)) where n is the length of nums
Did this code successfully run on Leetcode : Yes(#740)
Any problem you faced while coding this : No
Approach:
Create a dp array of size max(nums)+1 and store the count of each number in nums.
Iterate over the dp array and calculate the maximum points that can be earned by choosing or not choosing the number.
choosing = i * dp[i] + dp[i-2]
not choosing = dp[i-1]
Similar to house-robber problem.
'''

from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dp = [0] * (max(nums)+1)
        for n in nums:
            dp[n]+=1
        for i in range(2,len(dp)):
            dp[i] = max(i * dp[i] + dp[i-2],dp[i-1]) 
        return dp[-1]
    


#Driver code
sol = Solution()
print(sol.deleteAndEarn([3,4,2])) # 6