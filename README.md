# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)
# Edge case if the input array is empty then we return '0'. Get the maximum value from the array and
# create a new array of length - maximum value plus 1.
# Append the values of the array in the empty array, if the value exists then we add and update it.
# Initialize previous and current variables storing the first two values in the array and computing
# from the third position to new array length we will update the max value.
# Return the last value of the array which will be the maximum cost.

## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
# Edge case when the matrix is empty or has no entries we return '0'.
# Select the first value in the matrix and compare it with the other two values to find the minimum.
# We will continue this until the end of array and store the minimum values in a result array.
# Comparing the values in the result array we will return the min value.