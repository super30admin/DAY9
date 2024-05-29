# TC :- O(max (n) ) => O(N)
# SC :- O(max (n)) => O(N)

# where n is the array and max (n) is the largest number of the array.

# Approach :

# we create a array of size of the (max element+1)
# in the array, store the sum of the element at the arr[element] th index
# keep two varaibles skip and take
# let skip, take  be 0 initially
# store skip in a tempSkip variable
# calculate skip and take as follows
# skip = max(skip, take)
# take = arr[i] + tempSkip

import sys


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if not nums:
            return -1

        lenNums = len(nums)
        minValue = -sys.maxsize-1

        for i in range(lenNums):
            minValue = max(minValue, nums[i])

        arr = [0] * (minValue+1)

        for i in range(lenNums):
            index = nums[i]
            arr[index] = arr[index] + index

        skip = 0
        take = 0
        for i in range(1, len(arr)):
            tempSkip = skip
            skip = max(skip, take)
            take = arr[i] + tempSkip

        return max(skip, take)
