# Time Complexity : O(max(n, m)), where n is the number of elements in the given array, and m is the max elment in the given array
# Space Complexity : O(m), where m is the max element in the given array
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Its a premium problem, I could not run it 

# Your code here along with comments explaining your approach:

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums is None:
            return 0

        # dynamic array - should be of length max + 1
        dp = [0] * (max(nums) + 1)

        # traversing the given list - and using the values as indices for a new array
        # and then adding all occurences of every value at the corresponsing index
        for i in range(len(nums)):
            index = nums[i]
            dp[index] = dp[index] + nums[i]
        

        # using two extra variables
        # to store the status of skip/take of the previous element
        skip = 0
        take = 0

        # iterating the list 
        # where every index contains the max points available in the original array with that number
        # so we can check the max points if we skip/take previous - current elements
        # now this problem resembles house robber

        for i in range(len(dp)):
            tempSkip = skip
            # if we are skipping the current, doesnt matter if we took or skipped the previous
            # so taking max
            skip = max(skip, take)
            # if we are taking the current, then we skipped the previous
            # so we add the points of the current index
            take = tempSkip + dp[i]
        
        return max(skip, take)