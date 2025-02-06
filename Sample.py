'''
// Time Complexity :
Problem 1: 
Problem 2:
// Space Complexity :
Problem 1: 
Problem 2:
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1: Delete and Earn
# Edge case if the input array is empty then we return '0'. Get the maximum value from the array and
# create a new array of length - maximum value plus 1.
# Append the values of the array in the empty array, if the value exists then we add and update it.
# Initialize previous and current variables storing the first two values in the array and computing
# from the third position to new array length we will update the max value.
# Return the last value of the array which will be the maximum cost.
 
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        n = len(nums)
        max_val = 0
        for i in range(0,n):
            max_val = max(max_val, nums[i])
        
        arr = [0 for i in range(max_val + 1)]

        for i in range(0, n):
            curr = nums[i]
            arr[curr] += curr

        prev = arr[0]
        curr = max(arr[0], arr[1])
        for j in range(2, len(arr)):
            temp = curr
            curr = max(curr, arr[j] + prev)
            prev = temp
        return curr 

## Problem 2 - Minimum Falling Path Sum
# Edge case when the matrix is empty or has no entries we return '0'.
# Select the first value in the matrix and compare it with the other two values to find the minimum.
# We will continue this until the end of array and store the minimum values in a result array.
# Comparing the values in the result array we will return the min value.

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if matrix == None or len(matrix) == 0: return 0

        for i in range(1, len(matrix)):
            for j in range(len(matrix[i])):
                val = matrix[i][j]
                matrix[i][j] = val + matrix[i-1][j]
                if j > 0:
                    matrix[i][j] = min(matrix[i][j], val + matrix[i-1][j-1])
                if j < len(matrix[i]) - 1:
                    matrix[i][j] = min(matrix[i][j], val + matrix[i-1][j+1])
        
        min_val = matrix[len(matrix) - 1][0]
        for j in range(len(matrix[len(matrix) - 1])):
            if matrix[len(matrix)-1][j] < min_val:
                min_val = matrix[len(matrix)-1][j]
        return min_val   

