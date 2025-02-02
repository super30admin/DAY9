# Time Complexity : O(n) - n is len(nums)
# Space Complexity : O(n) - n is len(nums)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""

This is just variation of house robber
First, we create a list of 0 to max(nums), and then store the total of each of the number in nums at the index in the new list
Eg : nums = [2,2,3,3,3,4], sums_lst = [0,0,4,9,4]

Now sums_lst is nothing but like house robber
Maintain a dp array to store the max value possible at every index
Then for any given index we can do, max(prev, current value + result of prev_prev)
"""

def deleteAndEarn(nums):
    """
    :type nums: List[int]
    :rtype: int
    """

    n = len(nums)
    sum_lst = [0] * (max(nums) + 1)

    for i in range(0, n):
        sum_lst[nums[i]] += nums[i]

    dp = [0] * len(sum_lst)

    dp[0] = sum_lst[0]
    dp[1] = max(dp[0], sum_lst[1] + 0)

    for i in range(2, len(dp)):
        dp[i] = max(dp[i - 1], sum_lst[i] + dp[i - 2])

    return dp[len(dp) - 1]
