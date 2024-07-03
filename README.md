# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)

First we will iterate through all the elements in the array to get the maximum from the array. Then we will create an array which will have the sum of all the same elements at it's index. For example, at index 2 of arr will have sum of all 2s in the original nums array. First we will assign prev pointer to first element and current pointer to the element which is maximum between prev and current. Then we will loop from second element to the last element of arr. Now in this loop what we will do is we will store the current pointer in the temporary variable and check the maximum between current pointer sum and the sum of prev and current + 1 sum. For example, we will check maximum between sum of 2s and sum of 3s and 4s. Then assign current pointer to that maximum and previous pointer to current. In this way our current pointer will always have the maximum sum. At the end we will just simply return the current pointer.



## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

We can follow same logic as we followed for Paint House. We will follow the approach from bottom row to top row. In the second last row of metrix we will check the condition for current element. If the current element is middle we will check 3 elements (1 below and 2 diagonal) which one is smaller and we will add it to current element and we will take care of edge cases (0th column and last column) separately. At the end of this computation the top row will have possible sums and we will iterate through just top row and check the minimum sum and return it.