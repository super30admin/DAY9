'''
Time Complexity :
O(max(m)+n)
Space Complexity : O(max(m))
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp=[0 for _ in range(max(nums)+1)]
        for i in range(len(nums)):
            dp[nums[i]]+=nums[i]
        print(dp)
        
        for i in range(2,max(nums)+1):
            dp[i]=max(dp[i-1], dp[i]+dp[i-2])
        
        return dp[-1]