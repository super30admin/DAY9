# Time Complexity :

# O(N) , N = Max(no. of elements in nums, maximum Element in the num array)


# Space Complexity :  

# O(N) , Creating a DP array and then using two variables to update the sum.


# Approach:
# Condense this problem to find the sum corresponding to selecting similar numbers, and putting that sum in 
# an array of length of maxElement from original nums array. Thus, we put the "sum" for each number to corresponding 
# index in the array. For eg, sum of 1's goes to index 1, sums of 2's goes to index 2.
# We approach the problem using either "selecting" or "not selecting" each number for getting maximum sum.
# Create two variables that store the "skip" and "take" values that corr. to "Not picking" and "picking"
# the number.
# ===> Then for Sum corr. to each number, update: skip = min(previous skip, previous take)
# ===>                                          : take = previous skip + current nums[i] value

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums)==0:
            return 0
        
        maxElem = 0

        for i in range(0, len(nums)):
            maxElem = max(maxElem, nums[i])
        print("Max Element: ", maxElem)
        
        # Initialize DP array
        dp = [0] * (maxElem+1)
        print("DP array for sum: ", dp)

        # Fill the DP array
        for i in range(0, len(nums)):
            index = nums[i]  # get index to storeand add this eleme to sum of corr. number
            dp[index] += index
        print("DP array for sum: ", dp)

        skip = 0
        take = dp[0]

        for i in range(0, len(dp)):
            tempSkip = skip
            skip = max(skip, take)
            take = tempSkip + dp[i]
        
        return max(skip, take)