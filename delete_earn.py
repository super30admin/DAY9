#Time Complexity - O(n + maxVal)
#Space Complexity - O(maxVal)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        # Find the maximum value in nums
        maxVal = max(nums)

        # Create an array where each index represents the total points for that number
        maxArr = [0] * (maxVal + 1)
        for num in nums:
            maxArr[num] += num
        
        # Initialize skip and take
        skip = 0
        take = 0

        # Iterate through the maxArr to calculate the maximum points
        for i in range(maxVal + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + maxArr[i]
        
        return max(skip, take)
