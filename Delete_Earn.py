# Approach:
# We first aggregate the points for each unique number in a dictionary, treating it like a "house" in a House Robber problem
# where choosing a number eliminates adjacent numbers. We then use dynamic programming to find the maximum points
# by either choosing a number (earning its total points and skipping adjacent numbers) or skipping it.

# Time Complexity : O(n + m) where n is the number of elements in nums and m is the range of unique values in nums
# Space Complexity : O(m), where m is the range of unique values in nums (used for points and dp arrays)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
from collections import defaultdict

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Create a dictionary to accumulate points for each unique number
        points = defaultdict(int)
        for num in nums:
            points[num] += num

        # Extract sorted unique numbers
        unique_nums = sorted(points.keys())
        
        # Initialize two variables for dynamic programming
        earn1, earn2 = 0, 0

        # Iterate over unique numbers to calculate maximum points using a variation of House Robber logic
        for i in range(len(unique_nums)):
            current_points = points[unique_nums[i]]
            if i > 0 and unique_nums[i] == unique_nums[i - 1] + 1:
                # If numbers are consecutive, decide to include current or skip
                temp = max(earn1, earn2 + current_points)
            else:
                # If numbers are not consecutive, add current_points to max of previous two earnings
                temp = earn1 + current_points
            # Update the earnings
            earn2, earn1 = earn1, temp
        
        # Final value of earn1 is the maximum points we can achieve
        return earn1
