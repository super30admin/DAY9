"""
DP-3

Problem1: (https://leetcode.com/problems/delete-and-earn/)

You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
 
Constraints:
1 <= nums.length <= 2 * 104
1 <= nums[i] <= 104

Time Complexity : O(max(maxElement or size of array))
Space Complexity : O(max(maxElement or size of array))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
This is similar to House Robber. 
Create Frequency Array: Calculate dp[num] += num for all numbers.
Initialize Variables: Set skip = 0 and take = dp[0].
Iterate and Update: For each number num, set skip = max(skip, take) and take = old_skip + points[num], then update skip and take.
Result: Return max(skip, take) after processing all numbers. 
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        
        max_num = max(nums)
        dp = [0] * (max_num+1) # which will keep track of num count in respective index

        for num in nums:
            dp[num] += num
        
        skip = 0 # not included
        take = dp[0] # included
        for i in range(1, max_num+1):
            old_skip = skip
            skip = max(skip, take)
            take = old_skip + dp[i]

        return max(skip, take)
            